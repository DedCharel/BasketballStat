package ru.nvg_soft.basketballstat.fragments

import android.graphics.Color
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.BarGraphSeries
import com.jjoe64.graphview.series.LineGraphSeries
import com.jjoe64.graphview.series.DataPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_reports.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import ru.nvg_soft.basketballstat.R
import ru.nvg_soft.basketballstat.presenters.ReportPresenter
import ru.nvg_soft.basketballstat.views.ReportView


class ReportFragment : MvpAppCompatFragment(R.layout.fragment_reports), ReportView {

//    @InjectPresenter
//    lateinit var reportPresenter: ReportPresenter
    private val reportPresenter by moxyPresenter { ReportPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val myView = inflater.inflate(R.layout.fragment_reports,container,false)
       val myGraph = myView.findViewById<GraphView>(R.id.graph)
        val myGraph2 = myView.findViewById<GraphView>(R.id.graph2)
        val series = LineGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        val series2 = BarGraphSeries<DataPoint>(
            arrayOf<DataPoint>(
                DataPoint(0.0, 1.0),
                DataPoint(1.0, 5.0),
                DataPoint(2.0, 3.0),
                DataPoint(3.0, 2.0),
                DataPoint(4.0, 6.0)
            )
        )
        myGraph.addSeries(series)
        myGraph2.addSeries(series2)
        series2.spacing
        return myView
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}