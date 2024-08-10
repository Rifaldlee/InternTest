package com.Intern.suitmediatest.model

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PalindromeViewModel : ViewModel() {
    var name by mutableStateOf("")
    var sentence by mutableStateOf("")
    var showDialog by mutableStateOf(false)
    var isPalindrome by mutableStateOf(false)
    var navigateToSecondScreen by mutableStateOf(false)
    var showErrorDialog by mutableStateOf(false)
    var errorMessage by mutableStateOf("")

    fun onCheckPalindrome() {
        if (sentence.isBlank()) {
            showErrorDialog = true
            errorMessage = "Please enter a palindrome to check."
        } else {
            isPalindrome = checkPalindrome(sentence)
            showDialog = true
        }
    }

    private fun checkPalindrome(input: String): Boolean {
        val cleanInput = input.replace("\\s".toRegex(), "").lowercase()
        return cleanInput == cleanInput.reversed()
    }

    fun onNext() {
        if (name.isBlank()) {
            showErrorDialog = true
            errorMessage = "Please enter your name before proceeding."
        } else {
            navigateToSecondScreen = true
        }
    }

    fun onDialogDismiss() {
        showDialog = false
    }

    fun onErrorDialogDismiss() {
        showErrorDialog = false
    }

    fun onNavigationHandled() {
        navigateToSecondScreen = false
    }
}