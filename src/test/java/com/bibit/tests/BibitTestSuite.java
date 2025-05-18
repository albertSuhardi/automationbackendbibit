package com.bibit.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BibitPostTest.class,
        BibitUpdateTest.class,
        BibitGetTest.class,
        BibitDeleteTest.class,
})

public class BibitTestSuite {
    
}
