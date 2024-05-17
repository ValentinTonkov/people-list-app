package com.example.peoplelistapp.ui.home

import android.os.Build.VERSION
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peoplelistapp.data.DataApplication
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.data.person.PersonViewModel
import com.example.peoplelistapp.data.person.PersonViewModelFactory
import com.example.peoplelistapp.ui.person.recyclerview.PersonAdapter
import com.example.peoplelistapp.ui.person.recyclerview.PersonListAdapter
import com.example.peoplelistapp.databinding.FragmentHomeBinding
import com.example.peoplelistapp.service.PeopleService
import retrofit2.Retrofit
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

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataViewModel: PersonViewModel by viewModels {
            PersonViewModelFactory((activity?.application as DataApplication).repository)
        }

        //adding new record
       // dataViewModel.insert(Person(name = "Ivan", age = 22))
        //dataViewModel.insert(Person(name = "Stoyan", age = 24))



        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.personRecyclerView.layoutManager = layoutManager

        val personListAdapter = PersonListAdapter()
        binding.personRecyclerView.adapter = personListAdapter

        val homeViewModel: HomeViewModel by viewModels()

        // making GET request
        homeViewModel.getAll()

        // making POST request
        //homeViewModel.create(Person(id = 123, name = "Maria", age = 22))

        // adding observer for the list of people, obtained from the API
        homeViewModel.allPeople.observe(viewLifecycleOwner) {
           personListAdapter.submitList(it)
        }

/*
        // adding observer for the list of people, obtained from the database
        dataViewModel.allPeople.observe(viewLifecycleOwner){
            // using PersonAdapter
            // binding.personRecyclerView.adapter = PersonAdapter(it)

            // using PersonListAdapter
            personListAdapter.submitList(it)
            // this also works
            //(binding.personRecyclerView.adapter as? PersonListAdapter)?.submitList(it)

        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}