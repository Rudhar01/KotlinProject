package com.example.kotlinproject.RecyclerView

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.car.ui.AlertDialogBuilder
import com.example.kotlinproject.R
import com.example.kotlinproject.RecyclerView.RoomDB.RoomDataBases
import com.example.kotlinproject.databinding.CustomDialogBinding
import com.example.kotlinproject.databinding.FragmentRecyclerBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

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
    lateinit var roomData : RoomDataBases
//    val studentViewModel : StudentViewModel by viewModels {
//        StudentViewModelFactory(RoomDataBases.getData(recyclerActivity).userDao())
//    }

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
        roomData = RoomDataBases.getData(requireContext())
        myAdapter = RecyclerAdapter(array,recyclerActivity,this)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = myAdapter
        getData()


//        StudentViewModel.allTasks
        binding.fabbtn.setOnClickListener {
            var dialog = BottomSheetDialog(recyclerActivity)
            dialog.setContentView(R.layout.custom_dialog2)
            dialog.window?.setLayout(
                android.app.ActionBar.LayoutParams.MATCH_PARENT,
                android.app.ActionBar.LayoutParams.MATCH_PARENT
            )
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
//                    array.add(
//                        ItemList(
//                            name.text.toString(),
//                            contact.text.toString(),
//                            age.text.toString()
//                        )
//                    )
//                    myAdapter.notifyDataSetChanged()

                    var Student = ItemList(
                        name = name.text.toString(),
                        contact = contact.text.toString(),
                        age = age.text.toString()
                    )
                   roomData.userDao().insertUser(Student)

//                   roomData.userDao().deleteUser(5)
                    getData()

                    myAdapter.notifyDataSetChanged()

                    dialog.dismiss()
                }
            }
        }




//        array.add(ItemList("Rudhar" , "1234455122" , "19"))
//        array.add(ItemList("Raj" , "1234635122" , "20"))
//        array.add(ItemList("Rahul" , "1236845122" , "21"))
//        array.add(ItemList("Gaurav" , "1212445122" , "18"))
        // Inflate the layout for this fragment

        return binding.root
    }

     override fun displayItem(position : Int) {
         var userid : Int = array[position].id
//         var name = array[position].name
//        var contact = array[position].contact
//        var age = array[position].age
//    println("Check id : $userid")
        recyclerActivity.navController.navigate(R.id.testFragment,bundleOf("id" to userid ))
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
             var contact = dialog.findViewById<TextView>(R.id.HintContact)
             var age = dialog.findViewById<TextView>(R.id.HintAge)
             var save = dialog.findViewById<Button>(R.id.BtnSave)
             name.setText(array[position].name)
             contact.setText(array[position].contact)
             age.setText(array[position].age)
             save?.setOnClickListener {
                 if (name?.text!!.isEmpty()) {
                     name?.error = "Enter your name"

                 } else {

//                     array.set(
//                         position,
//                         ItemList(
//                             name.text.toString(),
//                             contact.text.toString(),
//                             age.text.toString()
//                         )
//                     )
//                     myAdapter.notifyDataSetChanged()
                   //  var id = array[position].id
                     var Student = ItemList(
                         array[position].id,
                         name = name.text.toString(),
                         contact = contact.text.toString(),
                         age = age.text.toString()
                     )
                     roomData.userDao().updateUser(Student)
                     getData()
                     dialog.dismiss()
                 }

             }

     }




    override fun delete(position: Int) {
        var dialog = AlertDialogBuilder(requireContext())
        dialog.setTitle("Delete")
        dialog.setMessage("Do you really want to delete ?")
        dialog.setPositiveButton("Delete"){_,_ ->
//            array.removeAt(position)
//            myAdapter.notifyDataSetChanged()
            var userId = array[position].id
            roomData.userDao().deleteUser(userId)
            getData()
        }
        dialog.setNegativeButton("Cancel"){_,_ ->
        }
        dialog.show()
    }
    fun getData(){
        array.clear()
        array.addAll(roomData.userDao().getAllTasks())
        myAdapter.notifyDataSetChanged()
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