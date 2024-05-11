package com.example.peoplelistapp.ui.person.new_person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.peoplelistapp.R
import com.example.peoplelistapp.data.DataApplication
import com.example.peoplelistapp.data.person.Person
import com.example.peoplelistapp.data.person.PersonViewModel
import com.example.peoplelistapp.data.person.PersonViewModelFactory
import com.example.peoplelistapp.databinding.FragmentNewPersonBinding
import com.example.peoplelistapp.databinding.FragmentPersonInfoBinding

class NewPersonFragment : Fragment() {

    private lateinit var binding: FragmentNewPersonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataViewModel: PersonViewModel by viewModels {
            PersonViewModelFactory((activity?.application as DataApplication).repository)
        }

        binding.addNewPersonButton.setOnClickListener {
            val personName = binding.newPersonNameText.text.toString()
            val personAgeString = binding.newPersonAgeText.text.toString()

            if (personName.isNotEmpty() && personAgeString.toIntOrNull() != null) {
                    val personAge = personAgeString.toInt()
                    dataViewModel.insert(Person(name = personName, age = personAge))
                    findNavController().popBackStack()  // removes current destination from the back stack
            } else {
                Toast.makeText(requireContext(), "Invalid input", Toast.LENGTH_SHORT).show()
            }
        }
    }

}