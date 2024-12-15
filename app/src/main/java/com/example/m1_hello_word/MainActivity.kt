package com.example.m1_hello_word

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.view.isInvisible
import com.example.m1_hello_word.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var counter = 0
    var balance = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        fun update(state: UiState) {
            when (state) {
                UiState.StartState(true) -> {
                    binding.loadingPassengers1.isInvisible = false
                    binding.loadingPassengers2.isInvisible = true
                    binding.loadingPassengers3.isInvisible = true
                    binding.buttonReset.isInvisible = true
                    binding.buttonRemove.isInvisible = true
                    binding.buttonAdd.isInvisible = false
                    binding.buttonBalance.isInvisible = true

                }
                UiState.AverageState(true) -> {
                    binding.loadingPassengers1.isInvisible = true
                    binding.loadingPassengers2.isInvisible = false
                    binding.loadingPassengers3.isInvisible = true
                    binding.buttonReset.isInvisible = true
                    binding.buttonRemove.isInvisible = false
                    binding.buttonAdd.isInvisible = false
                    binding.buttonBalance.isInvisible = false
                }
                UiState.FinalState(true) -> {
                    binding.loadingPassengers1.isInvisible = true
                    binding.loadingPassengers2.isInvisible = true
                    binding.loadingPassengers3.isInvisible = false
                    binding.buttonReset.isInvisible = false
                    binding.buttonRemove.isInvisible = false
                    binding.buttonAdd.isInvisible = true
                    binding.buttonBalance.isInvisible = true
                }
            }

        }
        //>>>>>>>>>>начальный эеран
        binding.buttonCounter.text = counter.toString()
        binding.loadingPassengers1.text =
            binding.loadingPassengers1.context.getText(R.string.text_1)
        update(UiState.StartState(true))
        //<<<<<<<<<<<

        fun getText(): String {
            val text = when (counter >= 0) {
                (counter == 0) -> {
                    binding.loadingPassengers1.text =
                        binding.loadingPassengers1.context.getText(R.string.text_1)
                    update(UiState.StartState(true))
                }
                (counter in 1..49) -> {
                    binding.loadingPassengers2.text =
                        binding.loadingPassengers2.context.getText(R.string.text_2)
                    binding.buttonBalance.text =
                        binding.buttonBalance.context.getText(R.string.Balance)
                    update(UiState.AverageState(true))
                }
                else -> {
                    binding.loadingPassengers3.text =
                        binding.loadingPassengers3.context.getText(R.string.text_3)
                    update(UiState.FinalState(true))
                }
            }
            return text.toString()
        }

        binding.buttonReset.setOnClickListener {
            counter = 0
            getText()
            binding.buttonCounter.text = counter.toString()
            binding.buttonAdd.isInvisible = false
            binding.buttonRemove.isInvisible = true
        }


        fun getBalance(): String {
            val i = counter
            when (i) {
                in 0..COUNTER_MAX -> balance = COUNTER_MAX - i
                else -> {}
            }
            getText()
            binding.buttonCounter.text = counter.toString()
            binding.buttonBalance.text = balance.toString()
            return balance.toString()
        }

        binding.buttonAdd.setOnClickListener {
            counter++
            getBalance()
        }

        binding.buttonRemove.setOnClickListener {
            counter--
            getBalance()
        }
    }

    private val COUNTER_MAX = 50
}
/*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            M1_Hello_WordTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    M1_Hello_WordTheme {
        Greeting("Android")
    }
}
 */
