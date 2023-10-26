package com.valoy.microfeat.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.valoy.microfeat.databinding.FragmentDashboardBinding
import com.valoy.microfeat.ui.common.foo.FooComposableFactory
import com.valoy.microfeat.ui.home.HomeScreen
import com.valoy.microfeat.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    @Inject
    lateinit var fooComposableFactory: FooComposableFactory
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardViewModel: DashboardViewModel by viewModels()

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        binding.composeView.setContent {
            DashboardScreen(viewModel = dashboardViewModel, fooComposableFactory = fooComposableFactory)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}