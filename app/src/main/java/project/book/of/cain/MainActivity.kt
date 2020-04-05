package project.book.of.cain

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import project.book.of.cain.acts.ui.ActsScreen
import project.book.of.cain.acts.ui.ActsViewModel
import project.book.of.cain.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val actsViewModel by viewModel<ActsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actsViewModel.state().observe(this, Observer { render(it) })

        actsViewModel.onEvent(ActsScreen.Event.FetchActs)
    }

    private fun render(state: ActsScreen.State) {
        binding.text.text = state.toString()
    }
}
