package com.example.peoplelistapp.ui.person.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.peoplelistapp.R
import com.example.peoplelistapp.data.DataApplication
import com.example.peoplelistapp.data.person.PersonViewModel
import com.example.peoplelistapp.data.person.PersonViewModelFactory
import com.example.peoplelistapp.databinding.FragmentPersonInfoBinding

class PersonInfoFragment : Fragment() {
    private lateinit var binding: FragmentPersonInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPersonInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataViewModel: PersonViewModel by viewModels {
            PersonViewModelFactory((activity?.application as DataApplication).repository)
        }

        val args : PersonInfoFragmentArgs by navArgs()

        val personId = args.personId

        dataViewModel.getPersonById(personId).observe(viewLifecycleOwner){
            binding.personInfoText.text = it.toString()
        }



    }

}