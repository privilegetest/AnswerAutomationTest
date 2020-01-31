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
            Long verticalPixel = scrollPage.returnPreviousScrollHeights(numScrollsDown);
            scrollPage.ScrollbyPixel(0, 0);

            assertTrue(scrollPage.getPageContentHeader().equals("Infinite Scroll"),
                    "Alert text is incorrect");
        }
        @Test
        public void T8ScrollDownInfiniteThenUpOne() {
            int numScrollsDown = 2;
            InfiniteScrollPage scrollPage = homePage.clickInfiniteScroll();
            scrollPage.scrollToBottomOfPage(numScrollsDown);
            Long verticalPixel = scrollPage.returnPreviousScrollHeights(numScrollsDown);
            scrollPage.ScrollbyPixel(0, verticalPixel);
            /**expected result will depend on browser set up when running test**/

        }
    }
