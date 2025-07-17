package com.example.kotlinproject.BottomNavigation

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.compose.foundation.gestures.Orientation
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.car.ui.AlertDialogBuilder
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.ActivityBottomNavigationBinding
import com.example.kotlinproject.databinding.FragmentTest2Binding
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment2.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment2 : Fragment(), MyInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentTest2Binding
    lateinit var myAdapter: MyAdapter
    lateinit var bottomNavigationBinding: BottomNavigationActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationBinding = activity as BottomNavigationActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTest2Binding.inflate(layoutInflater)
        myAdapter = MyAdapter(requireContext(),bottomNavigationBinding.array,this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = myAdapter
        binding.addBtn.setOnClickListener {
            var dialog = BottomSheetDialog(requireContext())
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT)
            var name = dialog.findViewById<EditText>(R.id.HintName)
            var price = dialog.findViewById<EditText>(R.id.HintPrice)
            var add = dialog.findViewById<Button>(R.id.btnAdd)
            dialog.show()
            add?.setOnClickListener {
                if(name!!.text.isEmpty()){
                    name?.error = "Enter the name of the item"
                } else if(price?.text!!.isEmpty()){
                    price?.error = "Enter the price of the item"
                }else
                bottomNavigationBinding.array.add(Item(
                   name.text.toString(),
                   price.text.toString()
               ))
                myAdapter.notifyDataSetChanged()
                dialog.dismiss()

            }

        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun edit(position: Int) {
        var dialog = Dialog(requireActivity())
        dialog.setContentView(R.layout.delete_update)
        dialog.window?.setLayout(
            android.app.ActionBar.LayoutParams.MATCH_PARENT,
            android.app.ActionBar.LayoutParams.WRAP_CONTENT
        )
        dialog.show()

        var name = dialog.findViewById<TextView>(R.id.HintName)
        var price = dialog.findViewById<TextView>(R.id.HintPrice)
        var save = dialog.findViewById<Button>(R.id.BtnSave)
        name.setText( bottomNavigationBinding.array[position].itemName)
        price.setText(bottomNavigationBinding.array[position].itemPrice)
        save?.setOnClickListener {
            if (name?.text!!.isEmpty()) {
                name?.error = "Enter item name"
            } else if (price?.text!!.isEmpty()) {
                price?.error = "Enter price of the item"
            } else {

                bottomNavigationBinding.array.set(
                    position,
                    Item(
                        name.text.toString(),
                        price.text.toString(),
                    )
                )
                myAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
    }

    override fun delete(position: Int) {
        var dialog = AlertDialogBuilder(requireContext())
        dialog.setTitle("Delete")
        dialog.setMessage("Do you really want to delete ?")
        dialog.setPositiveButton("Delete"){_,_ ->
            bottomNavigationBinding.array.removeAt(position)
            myAdapter.notifyDataSetChanged()

        }
        dialog.setNegativeButton("Cancel"){_,_ ->
        }
        dialog.show()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TestFragment2.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TestFragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}