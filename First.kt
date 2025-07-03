package com.example.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinproject.databinding.FragmentFirstBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [First.newInstance] factory method to
 * create an instance of this fragment.
 */
class First : Fragment(), clickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentFirstBinding
    lateinit var fragmentActivity: FragmentActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentActivity = activity as FragmentActivity
        fragmentActivity.clickInterface = this
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnSave.setOnClickListener {
            if (binding.etName.text.isEmpty()) {
                binding.etName.error = "Enter your name"
            } else {
                fragmentActivity.binding.tvName.text = binding.etName.text.toString()
            }
        }
        return binding.root
    }

    override fun changeColor(num: Int) {
        if(num==1){
            binding.mainLayout.setBackgroundColor(resources.getColor(R.color.red))
        }else if(num==2){
            binding.mainLayout.setBackgroundColor(resources.getColor(R.color.black))
        }else if(num==3){
            binding.mainLayout.setBackgroundColor(resources.getColor(R.color.offWhite))
        }else if(num==4){
            binding.mainLayout.setBackgroundColor(resources.getColor(R.color.blue))
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment First.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            First().apply {
                arguments = Bundle().apply {
                }
            }
    }
}