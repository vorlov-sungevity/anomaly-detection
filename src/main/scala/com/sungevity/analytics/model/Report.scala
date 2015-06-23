package com.sungevity.analytics.model

import org.joda.time.DateTime

import com.sungevity.analytics.helpers.Date._

case class Report(account: Account,
                  pgVoid: String,
                  openCase: String,
                  performanceRatio: Double,
                  pgNotes: String,
                  readings: Seq[ProductionData],
                  estimatedReadings: Seq[Double],
                  interconnectionDate: DateTime,
                  actualKwh: Double,
                  estimatedKwh: Double,
                  sum: Double,
                  blanksCount: Int,
                  smallValuesCount: Int,
                  neighbourhoodPerformanceRatio: Double,
                  neighbourhoodStdDev: Double,
                  neighbourhoodDevAvg: Double,
                  zScore: Double) {

  override def toString(): String = {
    s"account = [$account]," +
      s" pgVoid = [$pgVoid]," +
      s" openCase = [$openCase]," +
      s" performanceRatio = [$performanceRatio]," +
      s" pgNotes = [$pgNotes]," +
      s" readings = [$readings]," +
      s" estimatedReadings = [$estimatedReadings]," +
      s" interconnectionDate = [$interconnectionDate]," +
      s" actualKwh = [$actualKwh]," +
      s" estimatedKwh = [$estimatedKwh]," +
      s" blanksCount = [$blanksCount]," +
      s" hasSmallValues = [$smallValuesCount]," +
      s" neighbourhoodPerformanceRatio = [$neighbourhoodPerformanceRatio]," +
      s" neighbourhoodStdDev = [$neighbourhoodStdDev]," +
      s" neighbourhoodDevAvg = [$neighbourhoodDevAvg]," +
      s" zScore = [$zScore]"
  }

}

object Report {

  def apply(account: Account, pgVoid: String, openCase: String, pgNotes: String, readings: Seq[ProductionData], interconnectionDate: DateTime, actualKwh: Double) =
    new Report(account, pgVoid, openCase, 0.0, pgNotes, readings, Seq.empty[Double], interconnectionDate, actualKwh, 0.0, 0.0, 0, 0, 0.0, 0.0, 0.0, 0.0)

  def apply(report: Report): Report =
  new Report(
    report.account,
    report.pgVoid,
    report.openCase,
    report.performanceRatio,
    report.pgNotes,
    report.readings,
    report.estimatedReadings,
    report.interconnectionDate,
    report.actualKwh,
    report.estimatedKwh,
    report.sum,
    report.blanksCount,
    report.smallValuesCount,
    report.neighbourhoodPerformanceRatio,
    report.neighbourhoodStdDev,
    report.neighbourhoodDevAvg,
    report.zScore)
}
