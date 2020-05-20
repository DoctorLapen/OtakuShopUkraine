package com.lapin.otakushopukraine


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListFragment: Fragment() {
    interface OnItemClickListener {
        abstract fun onItemClick(position: Int, view: View?)
    }

    protected lateinit var rootView: View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ListAdapter

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
        setUpDummyData()
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
        recyclerView.adapter = adapter
    }

    private fun setUpDummyData(){


        val category = activity!!.intent.getStringExtra(keyCategory)
        var list: ArrayList<Product> = getProducts(category)



        adapter.addItems(list)
    }

    private fun getProducts(categoryName:String): ArrayList<Product> {
        var list: ArrayList<Product> = ArrayList<Product>()
        var kylons: ArrayList<Product> = ArrayList<Product>()
        var mangas: ArrayList<Product> = ArrayList<Product>()
        kylons.add(
            Product(
                "кулон \"Pokemon\" модель 4",
                R.drawable.kylon1,
                180f,
                "Тип : Кулон\n" + "Оригінал : \"Pokemon\"\n" + "Матеріал: Метал\n" + "Розмір: 4 см\n" + "Виробник: Guangzhou manufacture\n\n\n"
            )
        )
        kylons.add(
            Product(
                "Кулон \"Stranger Things\" модель 1",
                R.drawable.kylon2,
                250f,
                "Тип: Кулон\n" + "Оригінал: \"Stranger Things\"\n" + "Матеріал: Метал\n" + "Розмір: 4 см\n" + "Виробник: Guangzhou manufacture\n\n\n"
            )
        )
        kylons.add(
            Product(
                "Подвійний кулон \"One-Punch Man\"",
                R.drawable.kylon3,
                137f,
                "Тип : КулонОригінал : \"One-Punch Man\"" + " Матеріал: Метал Розмір: 4 см Виробник: Guangzhou manufacture\n" + "\n" + "\n"
            )
        )
        mangas.add(Product(
            "Манга «Дві зірки онмёджі» ",
            R.drawable.manga,
            109f,
            "Серії манги: Дві зірки онмёджі\n" +
                    "Томів: 20, випуск триває\n" +
                    "Автор SUKENO Yoshiaki\n" +
                    "Художник SUKENO Yoshiaki\n" +
                    "Жанри бойовик драма комедія пригоди романтика надприродне сенен жахи фентезі школа\n" +
                    "Виробництво: Україна\n" +
                    "Мова російська\n" +
                    "Дата релізу 2013\n" +
                    "Кількість сторінок: 219\n" +
                    "Вага: 210 гр.\n" +
                    "опис:\n" +
                    "З давніх часів доблесні оммёджі борються з поганою - злісними духами, народженими з людських страхів, болю і відчаю. Рокуро з дитинства мріяв стати найсильнішим оммёджі і очистити світ від скверни, але жахлива трагедія на довгі роки вбила в ньому будь-яке бажання боротися. Але кому є діло до бажань гіперактивного хлопчаки, коли від нього і талановитої дівчинки залежить доля всього світу?\n\n\n"

        ))
        if(categoryName =="Кулони"){
            list = kylons
        }
        else if(categoryName =="Манга"){
            list = mangas
        }

        return list
    }
}