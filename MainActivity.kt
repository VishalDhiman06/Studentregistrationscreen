package com.lpu.studentregistrationscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    StudentRegistrationScreen()
                }
            }
        }
    }
}

@Composable
fun StudentRegistrationScreen() {

    // ---------- State variables ----------
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    var selectedGender by remember { mutableStateOf("") } // RadioButton state
    var isTermsAccepted by remember { mutableStateOf(false) } // Checkbox state

    // ---------- Error states ----------
    var nameError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf(false) }
    var phoneError by remember { mutableStateOf(false) }
    var genderError by remember { mutableStateOf(false) }
    var termsError by remember { mutableStateOf(false) }

    // ---------- Submission result ----------
    var isSubmitted by remember { mutableStateOf(false) }

    val genderOptions = listOf("Male", "Female", "Other")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
    ) {

        Text(
            text = "Student Registration",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        // ---------- Name Field ----------
        OutlinedTextField(
            value = name,
            onValueChange = {
                name = it
                nameError = false
            },
            label = { Text("Full Name *") },
            isError = nameError,
            modifier = Modifier.fillMaxWidth()
        )
        if (nameError) {
            Text(
                text = "Name is required",
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---------- Email Field ----------
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                emailError = false
            },
            label = { Text("Email *") },
            isError = emailError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError) {
            Text(
                text = "Enter a valid email",
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ---------- Phone Field ----------
        OutlinedTextField(
            value = phone,
            onValueChange = {
                phone = it
                phoneError = false
            },
            label = { Text("Phone Number *") },
            isError = phoneError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        if (phoneError) {
            Text(
                text = "Enter a valid 10-digit phone number",
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ---------- Gender RadioButtons ----------
        Text(text = "Gender *", fontWeight = FontWeight.Medium)
        Row(verticalAlignment = Alignment.CenterVertically) {
            genderOptions.forEach { gender ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 12.dp)
                ) {
                    RadioButton(
                        selected = (selectedGender == gender),
                        onClick = {
                            selectedGender = gender
                            genderError = false
                        }
                    )
                    Text(text = gender)
                }
            }
        }
        if (genderError) {
            Text(
                text = "Please select your gender",
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // ---------- Terms Checkbox ----------
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isTermsAccepted,
                onCheckedChange = {
                    isTermsAccepted = it
                    termsError = false
                }
            )
            Text(text = "I agree to the Terms & Conditions *")
        }
        if (termsError) {
            Text(
                text = "You must accept the terms to continue",
                color = MaterialTheme.colorScheme.error,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ---------- Submit Button ----------
        Button(
            onClick = {
                // Run validations
                nameError = name.isBlank()
                emailError = !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                phoneError = phone.length != 10 || !phone.all { it.isDigit() }
                genderError = selectedGender.isBlank()
                termsError = !isTermsAccepted

                // If no errors, mark as submitted
                isSubmitted = !nameError && !emailError && !phoneError &&
                        !genderError && !termsError
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // ---------- Display Submitted Info ----------
        if (isSubmitted) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Registration Successful!",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(text = "Name: $name")
                    Text(text = "Email: $email")
                    Text(text = "Phone: $phone")
                    Text(text = "Gender: $selectedGender")
                    Text(text = "Terms Accepted: Yes")
                }
            }
        }
    }
}
