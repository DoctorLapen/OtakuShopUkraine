package com.lapin.otakushopukraine


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*


class ListFragment: Fragment() {
    interface OnItemClickListener {
        abstract fun onItemClick(position: Int, view: View?)
    }

    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListAdapter
    var list: ArrayList<Product> = ArrayList<Product>()
    private var mMessageReference: DatabaseReference? = null

    companion object {
        var TAG = ListFragment::class.java.simpleName
        const val ARG_POSITION: String = "positioin"

        fun newInstance(): ListFragment {
            var fragment = ListFragment();
            val args = Bundle()
            args.putInt(ARG_POSITION, 1)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onCreateComponent()
    }

    private fun onCreateComponent() {
        adapter = ListAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);
        initView()
        return rootView
    }

    private fun initView(){
        setUpAdapter()
        initializeRecyclerView()
    }

    private fun setUpAdapter() {
        adapter.setOnItemClickListener(onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(position: Int, view: View?) {
                var user = adapter.getItem(position)
                startActivity(context?.let {ctx ->
                    user?.let {
                            user -> ProductViewActivity.newIntent(ctx, user)
                    }
                })
            }
        })
    }

    private fun initializeRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val category = requireActivity().intent.getStringExtra(keyCategory)
        setUpFirebaseRealTime(category)
    }



    private fun setUpFirebaseRealTime(categoryName:String)
    {

        mMessageReference = FirebaseDatabase.getInstance().getReference("Categories/Manga/products")
        mMessageReference!!.addValueEventListener( object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                list.clear()
                for (dataSnapshot1 in dataSnapshot.children)
                {
                    val download: DownloadProduct? = dataSnapshot1.getValue(DownloadProduct::class.java)
                    val product = Product(download!!)
                    list.add(product)
                    Log.d("jlkjlk",download!!.toString())
                }
                recyclerView.adapter = adapter
                adapter.addItems(list)
                adapter.notifyDataSetChanged()


            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }})


    }
}
