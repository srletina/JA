/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ja.javafx;

import java.util.Random;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.Axis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;
import javafx.scene.shape.Line;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author luizrobertofreitas
 */
public class ResizableChartWithinScrollPane extends Application {

    public static void main(String... args) {
        launch(args);
    }

    @SuppressWarnings("unused")
	@Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Scroll Me");

        Random random = new Random(12);

        Axis<Number> xAxis = new NumberAxis("Time: s", 0, 4, 1);
        xAxis.setAutoRanging(false);
        NumberAxis yAxis = new NumberAxis();

//        ObservableList<Data<Double, Integer>> seriesData = FXCollections.observableArrayList();
//        XYChart.Series<Double, Integer> series = new XYChart.Series<>("Rotation", seriesData);
//        ObservableList<Data<Double, Integer>> series2Data = FXCollections.observableArrayList();
//        XYChart.Series<Double, Integer> series2 = new XYChart.Series<>("Speed", series2Data);
        ObservableList<Data<Number, Number>> seriesData = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> series = new XYChart.Series<>("Rotation", seriesData);
        ObservableList<Data<Number, Number>> series2Data = FXCollections.observableArrayList();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>("Speed", series2Data);

        double tempoXAxis = 0.0;

        for (int i = 0; i < 100; i++) {
            seriesData.add(new Data<>(tempoXAxis, random.nextInt(12)));
            series2Data.add(new Data<>(tempoXAxis, random.nextInt(12)));
            tempoXAxis += 0.04;
        }

        //ObservableList allSeriesData = FXCollections.observableArrayList(series, series2);
        //ObservableList<Series<Number, Number>> allSeriesData = FXCollections.observableArrayList(series, series2);
        ObservableList<Series<Number, Number>> allSeriesData = FXCollections.observableArrayList();
        allSeriesData.add(series);
        allSeriesData.add(series2);

        final AreaChart<Number, Number> areaChart = new AreaChart<>(xAxis, yAxis);
        areaChart.getData().addAll(allSeriesData);
        areaChart.setPrefSize(500, 200);

        final ScrollPane pane = new ScrollPane();
        pane.setContent(areaChart);
        pane.setPrefSize(600, 300);

        pane.setContent(areaChart);
        pane.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observableValue, Bounds oldBounds, Bounds newBounds) {
            	areaChart.setMinSize(Math.max(areaChart.getPrefWidth(), newBounds.getWidth()), Math.max(areaChart.getPrefHeight(), newBounds.getHeight()));
                pane.setPannable((areaChart.getPrefWidth() > newBounds.getWidth()) || (areaChart.getPrefHeight() > newBounds.getHeight()));
            }
        });

        areaChart.setOnScroll(new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent ev) {
                double zoomFactor = 1.05;
                double deltaY = ev.getDeltaY();

                if (deltaY < 0) {
                    zoomFactor = 2 - zoomFactor;
                }

                System.out.println("DeltaX = " + ev.getDeltaX());
                System.out.println("DeltaY = " + ev.getDeltaY());
                System.out.println("Zoomfactor = " + zoomFactor);

                NumberAxis xAxisLocal = ((NumberAxis) areaChart.getXAxis());

                xAxisLocal.setUpperBound(xAxisLocal.getUpperBound() * zoomFactor);
                xAxisLocal.setLowerBound(xAxisLocal.getLowerBound() * zoomFactor);
                xAxisLocal.setTickUnit(xAxisLocal.getTickUnit() * zoomFactor);

                ev.consume();
            }
        });

        Line cursorLine = new Line();

        Scene scene = new Scene(pane);
        stage.setScene(scene);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        stage.show();
    }
}
