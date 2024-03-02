package com.example.viewmodel_week7


import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BodyMassViewModel: ViewModel() {

    val heightInput: MutableState<String> = mutableStateOf("")
    val weightInput: MutableState<String> = mutableStateOf("")

    private var bmi: MutableState<Float> = mutableFloatStateOf(0.0f)

    // Methods for updating member variables when data changes
    fun updateHeightInput(newHeight: String) {
        heightInput.value = newHeight.replace(',', '.')
        calculateBMI()
    }

    fun updateWeightInput(newWeight: String) {
        weightInput.value = newWeight.replace(',', '.')
        calculateBMI()
    }

    // Getter for the BMI result
    fun getBMI(): MutableState<Float> {
        return bmi
    }

    // Private method for calculation
    private fun calculateBMI() {
        val height = heightInput.value.toFloatOrNull() ?: 0.0f
        val weight = weightInput.value.toIntOrNull() ?: 0
        bmi.value = if (weight > 0 && height > 0) weight / (height * height) else 0.0f
    }
}