package com.example.photontest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.photontest.ui.MainActivity;
import com.example.photontest.util.Constants.Samples;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);



    /**
     * Should validate the initial state of the screen
     * 1) Screen title
     * 2) Instructions
     * 3) Button reset disabled
     * 4) Button calculate enabled
     */
    @Test
    public void test_WelcomeState() {
        String screenTitle = getResourceString(R.string.lbl_main_title);
        String screenInstructions = getResourceString(R.string.lbl_main_instructions);
        onView(withId(R.id.title_tv)).check(matches(withText(screenTitle)));
        onView(withId(R.id.desc_tv)).check(matches(withText(screenInstructions)));
        onView(withId(R.id.reset)).check(matches(not(isEnabled())));
        onView(withId(R.id.submit)).check(matches(isEnabled()));
    }

    /**
     * Validate error on screen when user submits an empty input.
     * Should disable submit after click and re-enable after result
     * Should enable reset button after submission.
     */
    @Test
    public void test_SubmitEmptyInputShouldShowError() {
        String emptyError = getResourceString(R.string.error_empty);
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.submit)).check(matches(isEnabled()));
        onView(withId(R.id.error_tv)).check(matches(withText(emptyError)));
        onView(withId(R.id.reset)).check(matches(isEnabled()));
        onView(withId(R.id.submit)).check(matches(isEnabled()));
    }

    @Test
    public void test_SubmitNonNumericInputShouldShowError() {
        String error = getResourceString(R.string.error_input);
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_6_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText(error)));
    }

    @Test
    public void test_SubmitInvalidRowCountShouldShowError() {
        String error = getResourceString(R.string.error_rows);
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_16_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText(error)));
    }

    @Test
    public void test_SubmitInvalidMinColCountShouldShowError() {
        String error = getResourceString(R.string.error_cols);
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_14_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText(error)));
    }

    @Test
    public void test_SubmitInvalidMaxColCountShouldShowError() {
        String error = getResourceString(R.string.error_cols);
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_15_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText(error)));
    }

    @Test
    public void test_SubmitValidLargeInputShouldShowResult() {
        String valid = Samples.SAMPLE_13_VALID;
        String cost = String.valueOf(Samples.SAMPLE_13_COST);
        String path = Samples.SAMPLE_13_PATH;
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_13_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.valid_tv)).check(matches(withText(valid)));
        onView(withId(R.id.cost_tv)).check(matches(withText(cost)));
        onView(withId(R.id.path_tv)).check(matches(withText(path)));
    }

    @Test
    public void test_SubmitValidInputShouldShowResult() {
        String valid = Samples.SAMPLE_2_VALID;
        String cost = String.valueOf(Samples.SAMPLE_2_COST);
        String path = Samples.SAMPLE_2_PATH;
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_2_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.valid_tv)).check(matches(withText(valid)));
        onView(withId(R.id.cost_tv)).check(matches(withText(cost)));
        onView(withId(R.id.path_tv)).check(matches(withText(path)));
    }

    @Test
    public void test_SubmitValidInputInvalidMatrixShouldShowResult() {
        String valid = Samples.SAMPLE_3_VALID;
        String cost = String.valueOf(Samples.SAMPLE_3_COST);
        String path = Samples.SAMPLE_3_PATH;
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_3_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.valid_tv)).check(matches(withText(valid)));
        onView(withId(R.id.cost_tv)).check(matches(withText(cost)));
        onView(withId(R.id.path_tv)).check(matches(withText(path)));
    }

    @Test
    public void test_SubmitValidInputInvalidMatrixNoPathShouldShowResult() {
        String valid = Samples.SAMPLE_8_VALID;
        String cost = String.valueOf(Samples.SAMPLE_8_COST);
        String path = Samples.SAMPLE_8_PATH;
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_8_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.valid_tv)).check(matches(withText(valid)));
        onView(withId(R.id.cost_tv)).check(matches(withText(cost)));
        onView(withId(R.id.path_tv)).check(matches(withText(path)));
    }

    @Test
    public void test_shouldClearInputResultAndErrorMessageOnReset() {
        String valid = Samples.SAMPLE_3_VALID;
        String cost = String.valueOf(Samples.SAMPLE_3_COST);
        String path = Samples.SAMPLE_3_PATH;
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_3_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.valid_tv)).check(matches(withText(valid)));
        onView(withId(R.id.cost_tv)).check(matches(withText(cost)));
        onView(withId(R.id.path_tv)).check(matches(withText(path)));
        onView(withId(R.id.reset)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText("")));
        onView(withId(R.id.cost_tv)).check(matches(withText("")));
        onView(withId(R.id.path_tv)).check(matches(withText("")));
        onView(withId(R.id.valid_tv)).check(matches(withText("")));
        onView(withId(R.id.input_et)).check(matches(withText("")));

        String error = getResourceString(R.string.error_input);
        onView(withId(R.id.input_et)).perform(click());
        onView(withId(R.id.input_et)).perform(typeText(prepareInputFromMatrix(Samples.SAMPLE_6_INPUT)), closeSoftKeyboard());
        onView(withId(R.id.submit)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText(error)));
        onView(withId(R.id.reset)).perform(click());
        onView(withId(R.id.error_tv)).check(matches(withText("")));
        onView(withId(R.id.cost_tv)).check(matches(withText("")));
        onView(withId(R.id.path_tv)).check(matches(withText("")));
        onView(withId(R.id.valid_tv)).check(matches(withText("")));
        onView(withId(R.id.input_et)).check(matches(withText("")));
    }


    private String getResourceString(int id) {
        Context targetContext = InstrumentationRegistry.getTargetContext();
        return targetContext.getResources().getString(id);
    }

    private String prepareInputFromMatrix(Object[][] input) {
        StringBuilder inputFromMatrix = new StringBuilder();
        for(int rows = 0; rows<input.length; rows++) {
            for(int cols = 0; cols<input[0].length; cols++) {
                inputFromMatrix.append(input[rows][cols]).append(" ");
            }
            inputFromMatrix.append("\n");
        }
        return inputFromMatrix.toString();
    }

}
