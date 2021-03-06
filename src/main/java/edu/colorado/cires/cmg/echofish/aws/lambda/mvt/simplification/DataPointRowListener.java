package edu.colorado.cires.cmg.echofish.aws.lambda.mvt.simplification;

import edu.colorado.cires.cmg.tracklinegen.BaseRowListener;
import edu.colorado.cires.cmg.tracklinegen.GeoJsonMultiLineWriter;
import edu.colorado.cires.cmg.tracklinegen.GeometrySimplifier;
import java.util.function.Predicate;
import org.locationtech.jts.geom.GeometryFactory;

public class DataPointRowListener extends BaseRowListener<DataPointRow> {

  private static final Predicate<DataPointRow> FILTER = row ->
      row.getLat() != null
          && row.getLon() != null
          && row.getTimestamp() != null
          && !Double.isNaN(row.getLat())
          && !Double.isNaN(row.getLon());

  public DataPointRowListener(
      long msSplit,
      GeometrySimplifier geometrySimplifier,
      GeoJsonMultiLineWriter lineWriter,
      int batchSize,
      GeometryFactory geometryFactory,
      int geoJsonPrecision) {
    super(msSplit, geometrySimplifier, lineWriter, batchSize, FILTER, 0, geometryFactory, geoJsonPrecision);
  }
}
