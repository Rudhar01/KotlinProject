package com.example.kotlinproject.RecyclerView

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.FragmentRecyclerBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlin.collections.set

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerFragment : Fragment(), ClickAdapter {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding : FragmentRecyclerBinding
    lateinit var recyclerActivity : RecyclerActivity
     var array = ArrayList<ItemList>()
    lateinit var myAdapter : RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerActivity = activity as RecyclerActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecyclerBinding.inflate(layoutInflater)
        myAdapter = RecyclerAdapter(array,requireActivity(),this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = myAdapter
        fun openDialog(position: Int = -1){
            var dialog = BottomSheetDialog(recyclerActivity)
            dialog.setContentView(R.layout.custom_dialog)
            dialog.window?.setLayout(android.app.ActionBar.LayoutParams.MATCH_PARENT,android.app.ActionBar.LayoutParams.MATCH_PARENT)
            dialog.show()
            var name = dialog.findViewById<TextView>(R.id.HintName)
            var contact = dialog.findViewById<TextView>(R.id.HintContact)
            var age = dialog.findViewById<TextView>(R.id.HintAge)
            var save = dialog.findViewById<Button>(R.id.BtnSave)
            save?.setOnClickListener {
                if (name?.text!!.isEmpty()) {
                    name?.error = "Enter your name"
                } else if (contact?.text!!.isEmpty()) {
                    contact?.error = "Enter your contact number"
                } else if (age?.text!!.isEmpty()) {
                    age?.error = "Enter you age"
                } else {
                    if(position==-1)
                    array.add(
                            ItemList(name.text.toString(),
                                contact.text.toString(),
                                age.text.toString())
                        )
                        myAdapter.notifyDataSetChanged()
                        dialog.dismiss()

                }



            }
        }
        binding.fabbtn.setOnClickListener {
            openDialog(-1)
        }


        array.add(ItemList("Rudhar" , "1234455122" , "19"))
        array.add(ItemList("Raj" , "1234635122" , "20"))
        array.add(ItemList("Rahul" , "1236845122" , "21"))
        array.add(ItemList("Gaurav" , "1212445122" , "18"))
        // Inflate the layout for this fragment
        return binding.root
    }



     override fun edit(position: Int) {
         var dialog = Dialog(recyclerActivity)
         dialog.setContentView(R.layout.delete_update)
         dialog.window?.setLayout(
             android.app.ActionBar.LayoutParams.MATCH_PARENT,
             android.app.ActionBar.LayoutParams.MATCH_PARENT
         )
         dialog.show()
         var name = dialog.findViewById<TextView>(R.id.HintName)
         var contact = dialog.findViewById<TextView>(R.id.HintContact)
         var age = dialog.findViewById<TextView>(R.id.HintAge)
         var save = dialog.findViewById<Button>(R.id.BtnSave)
         var delete = dialog.findViewById<Button>(R.id.BtnDelete)
         save?.setOnClickListener {
             if (name?.text!!.isEmpty()) {
                 name?.error = "Enter your name"
             } else if (contact?.text!!.isEmpty()) {
                 contact?.error = "Enter your contact number"
             } else if (age?.text!!.isEmpty()) {
                 age?.error = "Enter you age"
             } else {

                 array.set(
                     position,
                     ItemList(
                         name.text.toString(),
                         contact.text.toString(),
                         age.text.toString()
                     )
                 )
                 myAdapter.notifyDataSetChanged()
                 dialog.dismiss()
             }

         }
         delete?.setOnClickListener {

             array.removeAt(position)
             myAdapter.notifyDataSetChanged()
             dialog.dismiss()
         }

     }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecyclerFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }

    }
}