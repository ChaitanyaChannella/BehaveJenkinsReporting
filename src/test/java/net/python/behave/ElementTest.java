package net.python.behave;

import net.python.behave.json.BehaveFeature;
import net.python.behave.json.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static net.python.behave.FileReaderUtil.getAbsolutePathFromResource;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ElementTest {

    ReportParser reportParser;
    Element passingElement;
    Element failingElement;
    Element undefinedElement;
    Element skippedElement;
    Element taggedElement;



    public void setUpJsonReports() throws IOException {
        List<String> jsonReports = new ArrayList<String>();
        jsonReports.add(getAbsolutePathFromResource("net/python/behave/results1.json"));
        reportParser = new ReportParser(jsonReports);
        
        BehaveFeature passingFeature = reportParser.getFeatures().entrySet().iterator().next().getValue().get(0);
        BehaveFeature failingFeature = reportParser.getFeatures().entrySet().iterator().next().getValue().get(1);
        BehaveFeature undefinedFeature = reportParser.getFeatures().entrySet().iterator().next().getValue().get(2);
        BehaveFeature skippedFeature = reportParser.getFeatures().entrySet().iterator().next().getValue().get(3);

        passingFeature.processSteps();
        failingFeature.processSteps();
        undefinedFeature.processSteps();
        skippedFeature.processSteps();
        
        passingElement = passingFeature.getElements().get(0);
        failingElement = failingFeature.getElements().get(0);
        undefinedElement = undefinedFeature.getElements().get(0);
        skippedElement = skippedFeature.getElements().get(0);
        
        taggedElement = passingFeature.getElements().get(1);
    }

   /*  @Test
   public void shouldReturnSteps() {
        assertThat(passingElement.getSteps().get(0), is(Step.class));
    }

    @Test
    public void shouldReturnStatus() {
        assertThat(passingElement.getStatus(), is(Util.Status.PASSED));
        assertThat(failingElement.getStatus(), is(Util.Status.FAILED));
        assertThat(undefinedElement.getStatus(), is(Util.Status.PASSED));
        assertThat(skippedElement.getStatus(), is(Util.Status.PASSED));
    }*/

  /*  @Test
    public void shouldReturnNameWhenConfigSkippedTurnedOn() {
    	ConfigurationOptions.setSkippedFailsBuild(true);
    	try {
    		assertThat(passingElement.getStatus(), is(Util.Status.PASSED));
            assertThat(failingElement.getStatus(), is(Util.Status.FAILED));
            assertThat(undefinedElement.getStatus(), is(Util.Status.PASSED));
            assertThat(skippedElement.getStatus(), is(Util.Status.FAILED));
    	} finally {
    		// restore the initial state for next tests
    		ConfigurationOptions.setSkippedFailsBuild(false);
    	}
    }
    
    @Test
    public void shouldReturnNameWhenConfiUndefinedTurnedOn() {
    	ConfigurationOptions.setUndefinedFailsBuild(true);
    	try {
    		assertThat(passingElement.getStatus(), is(Util.Status.PASSED));
            assertThat(failingElement.getStatus(), is(Util.Status.FAILED));
            assertThat(undefinedElement.getStatus(), is(Util.Status.FAILED));
            assertThat(skippedElement.getStatus(), is(Util.Status.PASSED));
    	} finally {
    		// restore the initial state for next tests
    		ConfigurationOptions.setUndefinedFailsBuild(false);
    	}
    }

    
    @Test
    public void shouldReturnName() {
        assertThat(passingElement.getName(), is("<div class=\"passed\"><span class=\"scenario-keyword\">Background: </span> <span class=\"scenario-name\">Activate Credit Card</span></div>"
        ));
    }

    @Test
    public void shouldReturnKeyword() {
        assertThat(passingElement.getKeyword(), is("Background"));
    }

    @Test
    public void shouldReturnTagList(){
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("@fast");
        expectedList.add("@super");
        expectedList.add("@checkout");
        //assertThat(taggedElement.getTagList(), is(expectedList));
    }

    @Test
    public void shouldKnowIfHasTags(){
        //assertThat(taggedElement.hasTags(), is(true));
    }

    @Test
    public void shouldReturnTagsAsHtml(){
        //assertThat(taggedElement.getTagsList(), is("<div class=\"feature-tags\">@fast,@super,@checkout</div>"));
    }*/
    
}
