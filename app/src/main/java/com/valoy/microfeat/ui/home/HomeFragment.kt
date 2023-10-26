package com.valoy.microfeat.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.valoy.microfeat.databinding.FragmentHomeBinding
import com.valoy.microfeat.ui.common.foo.FooComposable
import com.valoy.microfeat.ui.common.foo.FooComposableFactory
import com.valoy.microfeat.ui.common.foo.FooComposableFactoryImpl
import com.valoy.microfeat.ui.common.foo.FooUiModel
import com.valoy.microfeat.ui.common.foo.FooUiModelImpl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var fooComposableFactory: FooComposableFactory

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.composeView.setContent {
            HomeScreen(viewModel = homeViewModel, fooComposableFactory = fooComposableFactory)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

