package herokuappTests;
import herokuappPages.InfiniteScrollPage;
import org.testng.annotations.Test;
import herokuappTests.BaseTests;

import static org.testng.Assert.assertTrue;

public class TC002_InfiniteScrollTests extends BaseTests {

        /************************************************************
         This class tests Infinite Scroll function. Each test sets the number of normal scrolls and assigns login input data,
         asserts if paragraph details in view match paragraph details stored at that index location in Herokuapp site
         and displays the result
         ************************************************************/
        @Test
        public void T7ScrollDownInfiniteThenBackToTop() {
            int numScrollsDown = 2;
            InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
            scrollPage.scrollToBottomOfPage(numScrollsDown);
            scrollPage.scrollToTop();
            assertTrue(scrollPage.getPageContentHeader().contains("Infinite Scroll"),
                    "Alert text is incorrect");
        }
        @Test
        public void T8ScrollDownInfiniteThenUpOne() {
            int numScrollsDown = 2;
            Number vertical = 0;
            InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
            scrollPage.scrollToBottomOfPage(numScrollsDown);
            scrollPage.scrollByPixel(vertical, scrollPage.returnPreviousScrollHeights(numScrollsDown));

            /*expected result will depend on browser set up when running test**/

        }
    }
