package com.ygraph.components.piechart

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ygraph.components.common.model.PlotType
import com.ygraph.components.piechart.charts.DonutPieChart
import com.ygraph.components.piechart.charts.PieChart
import com.ygraph.components.piechart.models.PieChartConfig
import com.ygraph.components.piechart.models.PieChartData

object ChartWrapper {

    /**
     * Wrapper compose method for drawing Pie Chart and Donut chart.
     * @param modifier : All modifier related property
     * @param plotType: Type of the chart (Pie or Donut)
     * @param pieChartData: data list for the pie chart
     */

    @Composable
    fun DrawChart(
        modifier: Modifier,
        plotType: PlotType,
        pieChartData: PieChartData,
        pieChartConfig: PieChartConfig,
        onSliceClick: (PieChartData.Slice) -> Unit = {}
    ) {
        when (plotType) {
            is PlotType.Pie -> {
                PieChart(
                    modifier = modifier,
                    pieChartData = pieChartData,
                    pieChartConfig = pieChartConfig,
                    onSliceClick = onSliceClick
                )
            }
            is PlotType.Donut -> {
                DonutPieChart(
                    modifier = modifier,
                    pieChartData = pieChartData,
                    pieChartConfig = pieChartConfig,
                    onSliceClick = onSliceClick
                )
            }
        }
    }
}
