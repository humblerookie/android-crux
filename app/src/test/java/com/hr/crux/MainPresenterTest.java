package com.hr.crux;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hr.crux.core.model.GResult;
import com.hr.crux.core.presenter.MainActivityPresenter;
import com.hr.crux.core.view.MainActivityView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import rx.observers.TestSubscriber;

import static org.mockito.Mockito.verify;

public class MainPresenterTest {


    MainActivityPresenter mainActivityPresenter;

    private static final String string = "{\"predictions\":[{\"description\":\"Gujarat, India\",\"id\":\"4332c7e31ca33b625a86d216b2d076ab6d33118f\",\"matched_substrings\":[{\"length\":4,\"offset\":0}],\"place_id\":\"ChIJlfcOXx8FWTkRLlJU7YfYG4Y\",\"reference\":\"CjQmAAAA2SzLTgmRCVi9MEpVJnlkO_ViHrurPIVa4SIjR5k7CPqXlx28dh0Os_g56FvAHmO7EhDqrzAA-Ohzt0Y7Lhe7sISpGhTLDS6-4JeeOnbt_3ozvK7bRpEWZg\",\"terms\":[{\"offset\":0,\"value\":\"Gujarat\"},{\"offset\":9,\"value\":\"India\"}],\"types\":[\"administrative_area_level_1\",\"political\",\"geocode\"]},{\"description\":\"Gujarati Society, Mumbai, Maharashtra, India\",\"id\":\"b6b3a15a8a4746057db4e517f7379192bff67eef\",\"matched_substrings\":[{\"length\":4,\"offset\":0}],\"place_id\":\"ChIJ3awHNbPJ5zsRGv77sd2L35s\",\"reference\":\"ClREAAAATI-VOgogXti2ITRJrlYtbASMVlBWZX5m0WmAGV0yLAf9plvvrbGHqd-2zWnTlJF_luzfDoTnG9Pi3MErRxohxBXk6AKjVsGMfkuoaHqzmdoSENTKj3p08s-glkhWsrrR5poaFARcmr5T3eF_Nef_UiF6B7YSq9S0\",\"terms\":[{\"offset\":0,\"value\":\"Gujarati Society\"},{\"offset\":18,\"value\":\"Mumbai\"},{\"offset\":26,\"value\":\"Maharashtra\"},{\"offset\":39,\"value\":\"India\"}],\"types\":[\"sublocality_level_3\",\"sublocality\",\"political\",\"geocode\"]},{\"description\":\"Gujarat colours & coatings (P) Ltd, Mumbai, Maharashtra, India\",\"id\":\"f4ac7f02e54f21cf2c1f3819f36e8fb001767bc4\",\"matched_substrings\":[{\"length\":4,\"offset\":0}],\"place_id\":\"ChIJq6qqqs_H5zsRw8yTr8o6_Ds\",\"reference\":\"ClRMAAAAgKOQ-XJzUlOkMMAAK8ljwvJGqFyCfws8_DtHbclMyUFBMd2KzcBHL2D_fcpkhuQPtR7voF7VbJgFhVxkuLko_bJGtV0NDZjcMZvqWtlHw_MSEN3A8dd_Srs3KeN1PCvha70aFADn4ykXXhiZRscIiu_a65Xd6nyh\",\"terms\":[{\"offset\":0,\"value\":\"Gujarat colours & coatings (P) Ltd\"},{\"offset\":36,\"value\":\"Mumbai\"},{\"offset\":44,\"value\":\"Maharashtra\"},{\"offset\":57,\"value\":\"India\"}],\"types\":[\"establishment\"]},{\"description\":\"Gujarat Plastic Industries, Ghatkopar West, Mumbai, Maharashtra, India\",\"id\":\"5da4776c5fff53855a52f5707f5a4074dad27ede\",\"matched_substrings\":[{\"length\":4,\"offset\":0}],\"place_id\":\"ChIJy1v7ksXH5zsRtNBkOyXq4zY\",\"reference\":\"CmRUAAAAhX5BMLAnfvvjWalX2a_9S3OPSU-KZAcs9Q3s868EyK_srzULpXp66Vib481bkqYrH9kwmKajh6EV5iLbpR6mXM3v8ICV0lF0xoBsZkqptuIuWemxAxkpA_kETt89KurYEhBUfI8izqinXvWlGI7lLGREGhTiukLHkc4eD9Y1xEk-dAywT0EA2w\",\"terms\":[{\"offset\":0,\"value\":\"Gujarat Plastic Industries\"},{\"offset\":28,\"value\":\"Ghatkopar West\"},{\"offset\":44,\"value\":\"Mumbai\"},{\"offset\":52,\"value\":\"Maharashtra\"},{\"offset\":65,\"value\":\"India\"}],\"types\":[\"establishment\"]},{\"description\":\"Steel Gujarat Limited, Mumbai, Maharashtra, India\",\"id\":\"08c572b5832686ff6ec0443b1cdc5153cbcc9c4f\",\"matched_substrings\":[{\"length\":4,\"offset\":6}],\"place_id\":\"ChIJxdr-fNTO5zsR0HdTdJXNyxE\",\"reference\":\"CkQ_AAAAR4k5JLCyS6rKxjlNz5bMF55sTR60PZl3xspec_k1gubKdYiILO0UK74JaTNsVM-rh6Ln7qZ8EJU0fyIrWF2d8RIQ2rqYWZQEOj_lFt3YGIKcLRoUf-Cfqv7o6kc3f4rnPpqL0gkY-W0\",\"terms\":[{\"offset\":0,\"value\":\"Steel Gujarat Limited\"},{\"offset\":23,\"value\":\"Mumbai\"},{\"offset\":31,\"value\":\"Maharashtra\"},{\"offset\":44,\"value\":\"India\"}],\"types\":[\"establishment\"]}],\"status\":\"OK\"}";

    @Mock
    Application application;

    @Mock
    MainActivityView mainActivityView;

    @Before
    public void init() {

        MockitoAnnotations.initMocks(this);
        application = new Application();
        application.onCreate();
        mainActivityPresenter = new MainActivityPresenter();
        mainActivityPresenter.attachView(mainActivityView);

    }

    @Test
    public void textTyped_CallsApi() {


        TestSubscriber<GResult> testSubscriber = new TestSubscriber<>();
        mainActivityPresenter.onTextChanged("Guja");
        //Verify progress shown
        verify(mainActivityView).showLoading(false);
        testSubscriber.assertNoErrors();

        List<GResult> gResults = new ArrayList<>();
        gResults.add(new Gson().fromJson(string, new TypeToken<GResult>() {
        }.getType()));

        testSubscriber.assertReceivedOnNext(gResults);
    }


    @After
    public void release() {
        mainActivityPresenter.detachView(false);
    }
}
