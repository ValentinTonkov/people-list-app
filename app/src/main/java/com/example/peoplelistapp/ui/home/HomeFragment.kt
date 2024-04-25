package com.example.peoplelistapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.peoplelistapp.data.DataApplication
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.data.person.PersonViewModel
import com.example.peoplelistapp.data.person.PersonViewModelFactory
import com.example.peoplelistapp.databinding.FragmentHomeBinding
import java.lang.StringBuilder

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataViewModel: PersonViewModel by viewModels {
            PersonViewModelFactory((activity?.application as DataApplication).repository)
        }

        //adding new record
        //dataViewModel.insert(Person(name = "Ivan", age = 22))

        dataViewModel.allPeople.observe(viewLifecycleOwner){
            val builder = StringBuilder()
            it.forEach {
                builder.append(it).append('\n')
            }
            binding.textHome.text = builder.toString()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}