package com.example.kotlinproject.ViewList

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.FragmentCustomizeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.text.set

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CustomizeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CustomizeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var viewList: ListView1
    lateinit var binding: FragmentCustomizeBinding
    var array = arrayListOf<MyData>()
    lateinit var myAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewList = activity as ListView1
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCustomizeBinding.inflate(layoutInflater)
        array?.add(MyData("Raj", "3546323432"))
        array?.add(MyData("Rahul", "3546323431"))
        array?.add(MyData("Rakshit", "3546323433"))
        myAdapter = CustomAdapter(array)
        binding.lvList1.adapter = myAdapter
        fun save(position: Int = -1) {
            var dialog = BottomSheetDialog(viewList)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(
                android.app.ActionBar.LayoutParams.MATCH_PARENT,
                android.app.ActionBar.LayoutParams.MATCH_PARENT
            )
            dialog.show()
            var name = dialog.findViewById<EditText>(R.id.HintName)
            var contact = dialog.findViewById<EditText>(R.id.HintContact)
            var save = dialog.findViewById<Button>(R.id.BtnSave)
            save?.setOnClickListener {
                if (name?.text!!.isEmpty()) {
                    name?.error = "Enter your name"
                } else if (contact?.text!!.isEmpty()) {
                    contact?.error = "Enter your contact number"
                } else {

                    if (position == -1) {
                        array.add(MyData(name.text.toString(), contact.text.toString()))
                        myAdapter.notifyDataSetChanged()
                        dialog.dismiss()

                    } else {
                        array.set(position, MyData(name.text.toString(), contact.text.toString()))
                        myAdapter.notifyDataSetChanged()
                        dialog.dismiss()
                    }
                }
            }
        }

        binding.newBtnFab.setOnClickListener {
            save(-1)
        }


        binding.lvList1.setOnItemClickListener { parent, view, position, id ->
            save(position)
            return@setOnItemClickListener
        }

        // Inflate the layout for this fragment

        binding.lvList1.setOnItemLongClickListener { parent, view, position, id ->
            array.removeAt(position)
            myAdapter.notifyDataSetChanged()
            return@setOnItemLongClickListener true
        }
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CustomizeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CustomizeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}




