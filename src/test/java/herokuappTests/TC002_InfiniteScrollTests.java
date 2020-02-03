package herokuappTests;

import herokuappPages.InfiniteScrollPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC002_InfiniteScrollTests extends BaseTests {

        /************************************************************
         This class tests Infinite Scroll function. Each test sets the number of normal scrolls and assigns login input data,
         asserts if paragraph details in view match paragraph details stored at that index location in Herokuapp site
         and displays the result
         ************************************************************/
       private int numScrollsToBottomOfPage = 2;
        private int numScrollsDown = 3;
        private int numScrollsUp = 1;
        @Test
        public void T7ScrollDownInfiniteThenBackToTop() {
            InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
            scrollPage.scrollToBottomOfPage(numScrollsToBottomOfPage);
            scrollPage.scrollToTopofPage();
            assertTrue(scrollPage.getPageContentHeader().contains("Infinite Scroll"),
                    "Alert text is incorrect");
        }
        @Test
        public void T8ScrollDownThenUp() {
            InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
            scrollPage.scrollToBottomOfPage(numScrollsDown);
            scrollPage.scrollBackUp(numScrollsDown,numScrollsUp);
            assertTrue(scrollPage.getPageContentHeader().contains("Illum voluptatum"),
                    "Alert text is incorrect");
            /*expected result will depend on browser set up when running test**/
        }
    }
