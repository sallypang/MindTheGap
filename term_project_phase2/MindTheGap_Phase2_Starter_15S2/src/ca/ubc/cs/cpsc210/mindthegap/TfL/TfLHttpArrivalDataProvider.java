package ca.ubc.cs.cpsc210.mindthegap.TfL;

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    private Station stn;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    /**
     * Produces URL used to query TfL web service for expected arrivals at
     * station specified in call to constructor.
     *
     * @returns URL to query TfL web service for arrival data
     */
    protected URL getURL() throws MalformedURLException {
        String request = "";

        String lineId = "";
        String result = "";
        // TODO Phase 2 Task 7
        // want to add all the ids together in a string, separated by commas. remove comma off the last id.
        for (Line line : stn.getLines()) {
            lineId =  line.getId();
            lineId = lineId + ",";
            result = result + lineId;

        }
        result = result.substring(0, result.length() - 2);
        request = "https://api.tfl.gov.uk/Line/" + result + "/Arrivals?stopPointId=" + stn.getID() + "&app_id=&app_key=";
        URL url = new URL(request);
        return url;

    }
}
