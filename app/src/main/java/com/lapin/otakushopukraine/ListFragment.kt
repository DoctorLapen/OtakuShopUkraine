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
        var list: ArrayList<Product> = ArrayList<Product>()
        list.add(Product("User 1", R.drawable.authorphoto,5.9f,"Автор Степан Шеіч\n" +
                "Видавець DC, Рідна мова\n" +
                "Обкладинка Тверда палітурка\n" +
                "Дата виходу 2020\n" +
                "сторінок 192\n" +
                "Формат 23,4х30 см\n" +
                "Мова Український\n" +
                "Персонажі Джокер, Харлі Квінн\n" +
                "На подарунок Дівчіні\n" +
                "«Благими намірами вимощена дорога в пекло»\n" +
                "\n" +
                "«На тій дорозі я зустріла блідого чоловіка»\n" +
                "\n" +
                "«І він мені посміхнувся ...»\n" +
                "\n" +
                "Доктор Харлін Квінзель - блискучий молодий психіатр, у якій є ліки від божевілля - робить різкі заходи, щоб врятувати Готем від самого себе.\n" +
                "\n" +
                "Зустрітися з народженням легендарної суперзлодейкі Харлі Квінн у вражаючому переосмисленні історії трагічного кохання Харлі і Джокера від відомого майстра сторітеллінга Степана Шеіча.\n" +
                "\n" +
                "Видання збільшеного формату!"))
        list.add(Product("User 2", R.drawable.authorphoto,56.7f,"Автор Степан Шеіч\n" +
                "Видавець DC, Рідна мова\n" +
                "Обкладинка Тверда палітурка\n" +
                "Дата виходу 2020\n" +
                "сторінок 192\n" +
                "Формат 23,4х30 см\n" +
                "Мова Український\n" +
                "Персонажі Джокер, Харлі Квінн\n" +
                "На подарунок Дівчіні\n" +
                "«Благими намірами вимощена дорога в пекло»\n" +
                "\n" +
                "«На тій дорозі я зустріла блідого чоловіка»\n" +
                "\n" +
                "«І він мені посміхнувся ...»\n" +
                "\n" +
                "Доктор Харлін Квінзель - блискучий молодий психіатр, у якій є ліки від божевілля - робить різкі заходи, щоб врятувати Готем від самого себе.\n" +
                "\n" +
                "Зустрітися з народженням легендарної суперзлодейкі Харлі Квінн у вражаючому переосмисленні історії трагічного кохання Харлі і Джокера від відомого майстра сторітеллінга Степана Шеіча.\n" +
                "\n" +
                "Видання збільшеного формату!"))
        list.add(Product("User 3", R.drawable.authorphoto,50.9f,"Автор Степан Шеіч\n" +
                "Видавець DC, Рідна мова\n" +
                "Обкладинка Тверда палітурка\n" +
                "Дата виходу 2020\n" +
                "сторінок 192\n" +
                "Формат 23,4х30 см\n" +
                "Мова Український\n" +
                "Персонажі Джокер, Харлі Квінн\n" +
                "На подарунок Дівчіні\n" +
                "«Благими намірами вимощена дорога в пекло»\n" +
                "\n" +
                "«На тій дорозі я зустріла блідого чоловіка»\n" +
                "\n" +
                "«І він мені посміхнувся ...»\n" +
                "\n" +
                "Доктор Харлін Квінзель - блискучий молодий психіатр, у якій є ліки від божевілля - робить різкі заходи, щоб врятувати Готем від самого себе.\n" +
                "\n" +
                "Зустрітися з народженням легендарної суперзлодейкі Харлі Квінн у вражаючому переосмисленні історії трагічного кохання Харлі і Джокера від відомого майстра сторітеллінга Степана Шеіча.\n" +
                "\n" +
                "Видання збільшеного формату!"))

        adapter.addItems(list)
    }
}