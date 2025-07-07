package com.example.kotlinproject.ViewList

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.compose.material3.Button
import androidx.fragment.app.FragmentActivity
import com.example.kotlinproject.AlertDialog
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.CustomDialog1Binding
import com.example.kotlinproject.databinding.CustomDialogBinding
import com.example.kotlinproject.databinding.FragmentNewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NewFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentNewBinding
    lateinit var viewList : ListView1
    lateinit var customDialog: CustomDialogBinding
    lateinit var customDialog1 : CustomDialog1Binding
    lateinit var arrayAdapter: ArrayAdapter<String>
    var array = arrayListOf("Rudhar","Rahul","Raj","Gaurav","Mohit")


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
        // Inflate the layout for this fragment
        customDialog = CustomDialogBinding.inflate(layoutInflater)
        customDialog1 = CustomDialog1Binding.inflate(layoutInflater)
        binding = FragmentNewBinding.inflate(layoutInflater)
        arrayAdapter = ArrayAdapter(viewList,android.R.layout.simple_list_item_1,array)
        binding.lvList.adapter = arrayAdapter
        binding.fabBtn.setOnClickListener {
            var dialog = BottomSheetDialog(viewList)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(android.app.ActionBar.LayoutParams.MATCH_PARENT,android.app.ActionBar.LayoutParams.MATCH_PARENT)
            var name = dialog.findViewById<EditText>(R.id.HintName)
            var save = dialog.findViewById<Button>(R.id.BtnSave)
            dialog.show()
            save?.setOnClickListener {
                if(name?.text!!.isEmpty()){
                    name?.error = "Enter the name"
                } else{
                    array.add(name?.text.toString())
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                    Toast.makeText(viewList,"Added",Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.lvList.setOnItemClickListener { parent , view , position , id ->
            var dialog = Dialog(viewList)
            dialog.setContentView(R.layout.custom_dialog1)
            dialog.window?.setLayout(android.app.ActionBar.LayoutParams.MATCH_PARENT,android.app.ActionBar.LayoutParams.MATCH_PARENT)

           var name = dialog.findViewById<EditText>(R.id.etText)
            var save = dialog.findViewById<Button>(R.id.btnUpdate)
           dialog.show()
            save.setOnClickListener {
                if(name.text.isEmpty()){
                    name.error = "Enter the name"
                }else {
                    array.set(position,name.text.toString())
                    arrayAdapter.notifyDataSetChanged()
                    dialog.dismiss()
                    Toast.makeText(viewList,"Updated",Toast.LENGTH_SHORT).show()
                }

            }
        }
        binding.lvList.setOnItemLongClickListener { parent , view , position, id ->
            array.removeAt(position)
            arrayAdapter.notifyDataSetChanged()
            Toast.makeText(viewList,"Deleted",Toast.LENGTH_SHORT).show()
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
         * @return A new instance of fragment NewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}