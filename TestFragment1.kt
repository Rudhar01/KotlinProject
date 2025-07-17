package com.example.kotlinproject.BottomNavigation

import android.app.ActionBar
import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinproject.R
import com.example.kotlinproject.databinding.FragmentTest1Binding
import com.example.kotlinproject.databinding.FragmentTest2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TestFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class TestFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentTest1Binding
    lateinit var bottomNavigationActivity: BottomNavigationActivity
    var array = ArrayList<OrderModel>()
    lateinit var myAdapter1: MyAdapter1
    lateinit var newAdapter : ArrayAdapter<Item>
    var item = ""
    var itemPrice = ""
    var quantity = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bottomNavigationActivity = activity as BottomNavigationActivity
        binding = FragmentTest1Binding.inflate(layoutInflater)
        myAdapter1 = MyAdapter1(requireContext(),array)
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView1.adapter = myAdapter1
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.fabBtn1.setOnClickListener {
            var dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.test1_layout)
            dialog.window?.setLayout(
                ActionBar.LayoutParams.MATCH_PARENT,
                ActionBar.LayoutParams.MATCH_PARENT
            )
            dialog.show()
            var spinner = dialog.findViewById<Spinner>(R.id.spinner1)
            newAdapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,bottomNavigationActivity.array)
            spinner.adapter = newAdapter
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    item = bottomNavigationActivity.array[position].itemName.toString()
                    itemPrice = bottomNavigationActivity.array[position].itemPrice.toString()
//
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
            var add = dialog.findViewById<Button>(R.id.BtnAdd)
            var quantity = dialog.findViewById<EditText>(R.id.etQuantity)
            add.setOnClickListener {
                   if(quantity.text.isEmpty()){
                       quantity.error = " Enter the quantity"
                   }else{
                       var oder = OrderModel(itemName = item, itemPrice = itemPrice, quantity = quantity.text.toString())
                       array.add(oder)
                       var sum = 0.0
                       for(i in array){
                         sum += i.itemPrice!!.toDouble()  * i.quantity!!.toDouble()

                       }
                       binding.etAmount.setText(sum.toString())
                       myAdapter1.notifyDataSetChanged()
                       dialog.dismiss()
                   }
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TestFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TestFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}