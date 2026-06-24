# 🎓 Student Registration Screen

A modern Android Student Registration application developed using **Kotlin** and **Jetpack Compose**. The application demonstrates form handling, state management, input validation, and Material 3 UI components.

---

## 📱 Features

* ✅ Student Registration Form
* ✅ Full Name Validation
* ✅ Email Validation
* ✅ 10-Digit Phone Number Validation
* ✅ Gender Selection using Radio Buttons
* ✅ Terms & Conditions Acceptance using Checkbox
* ✅ Real-time Error Handling
* ✅ Registration Success Card
* ✅ Scrollable Layout Support
* ✅ Material 3 Design Components
* ✅ Jetpack Compose State Management

---

## 🛠️ Built With

| Technology         | Usage                     |
| ------------------ | ------------------------- |
| Kotlin             | Programming Language      |
| Jetpack Compose    | UI Development            |
| Material 3         | UI Components             |
| Android Studio     | Development Environment   |
| State Management   | remember & mutableStateOf |
| Compose Foundation | Layouts and Scrolling     |

---

## 📂 Project Structure

```text
app/
└── src/
    └── main/
        └── java/
            └── com/lpu/studentregistrationscreen/
                └── MainActivity.kt
```

---

## 📸 Application Workflow

### 1. User Enters Details

* Full Name
* Email Address
* Phone Number

### 2. Select Gender

Available options:

* Male
* Female
* Other

### 3. Accept Terms

User must agree to the Terms & Conditions.

### 4. Validation Checks

The application validates:

* Name cannot be empty
* Email format must be valid
* Phone number must contain exactly 10 digits
* Gender must be selected
* Terms & Conditions must be accepted

### 5. Successful Registration

After successful validation, a confirmation card displays:

* Name
* Email
* Phone Number
* Gender
* Terms Accepted Status

---

## 💡 Validation Logic

### Name Validation

```kotlin
nameError = name.isBlank()
```

### Email Validation

```kotlin
emailError =
!Patterns.EMAIL_ADDRESS.matcher(email).matches()
```

### Phone Validation

```kotlin
phoneError =
phone.length != 10 || !phone.all { it.isDigit() }
```

### Gender Validation

```kotlin
genderError = selectedGender.isBlank()
```

### Terms Validation

```kotlin
termsError = !isTermsAccepted
```

---

## 🚀 Getting Started

### Clone the Repository

```bash
git clone https://github.com/your-username/StudentRegistrationScreen.git
```

### Open Project

Open the project using **Android Studio**.

### Run the Application

1. Sync Gradle
2. Connect an Android device or emulator
3. Click **Run ▶**

---

## 🎯 Learning Outcomes

This project demonstrates practical knowledge of:

* Jetpack Compose UI Development
* State Handling
* Form Validation
* Material Design 3
* Android Application Architecture
* User Input Processing
* Compose Layouts and Components

---

## 👨‍💻 Author

**Vishal Dhiman**

B.Tech Student | Android Developer | Kotlin Enthusiast

GitHub: https://github.com/your-github-username

---

## ⭐ Support

If you found this project useful, consider giving it a **Star ⭐** on GitHub.
