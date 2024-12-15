package com.example.m1_hello_word


open  class UiState{

    data class StartState(
        val isActivity: Boolean ): UiState()
    data class AverageState(
        val isActivity: Boolean ): UiState()
    data class FinalState(
        val isActivity: Boolean ): UiState()
}


