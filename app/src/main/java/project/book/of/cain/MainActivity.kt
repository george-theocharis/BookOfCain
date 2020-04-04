package project.book.of.cain

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel
import project.book.of.cain.acts.ui.ActsScreen
import project.book.of.cain.acts.ui.ActsViewModel

class MainActivity : AppCompatActivity() {

    private val actsViewModel by viewModel<ActsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actsViewModel.state().observe(this, Observer<ActsScreen.State> { render(it) })

        actsViewModel.onEvent(ActsScreen.Event.FetchActs)
    }

    private fun render(state: ActsScreen.State) {
        Log.d("STATE = ", state.toString())
    }
}
