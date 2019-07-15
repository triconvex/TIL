package ch3;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class SetupTeardownIncluder {

    private String pageData;
    private boolean isSuite;
    private String testPage;
    private StringBuffer newPageContent;

    public SetupTeardownIncluder(String pageData) {
        this.pageData = pageData;
        testPage = pageData.toLowerCase();
        newPageContent = new StringBuffer();
    }

    /**
     * 각 함수는 다음 함수를 소개한다
     * 내려가기 규칙
     */

    //SetupTeardownIncluder.render(pageData)는 단항으로 이해가 쉽다
    public static String render(String pageData) {
        return render(pageData, false); //default는 false? isSuite에 대한 값을 같이 전달해주는 경우에만 true로 진행?
    }

    public static String render(String pageData, boolean isSuite) {
        return new SetupTeardownIncluder(pageData).render(isSuite);
    }

    private String render(boolean isSuite) {
        this.isSuite = isSuite;

        //이것도 사실 지양해야한다
        //원래 renderForSuite()와 renderForSingleTest()로 나누어야한다
        //분기를 boolean 변수가 아닌 메서드로 분리
        if(isTestPage()) {
            includeSetupAndTeardownPages(); //include setup & teardown에 대한 작업 진행
        }
        return pageData.toLowerCase();
    }


    private boolean isTestPage() {
        return pageData.contains("Test");
    }

//----------------------------------------------------------------------------------------

        private void includeSetupAndTeardownPages() {
            includeSetupPages();
            includePageContent();
            includeTeardownPages();
            updatePageContent();
        }

//----------------------------------------------------------------------------------------

            private void includeSetupPages() {
                if(isSuite) {
                    includeSuiteSetupPage(); //isSuite 조건 충족여부로 각각의 메서드로 분리
                }

                includeSetupPage();
            }

                    private void includeSetupPage() {
                        include("SetUp", "-setup");
                    }

                    private void includeSuiteSetupPage() {
                        include("SuiteSetUp", "-setup");
                    }

//----------------------------------------------------------------------------------------

            private void includePageContent() {
                newPageContent.append(pageData.toLowerCase());
            }

//----------------------------------------------------------------------------------------

            private void includeTeardownPages() {
                includeTeardownPage();

                if(isSuite) {  //isSuite 조건 충족여부로 각각의 메서드로 분리
                    includeSuiteTeardownPage();
                }
            }

                    private void includeTeardownPage() {
                        include("TearDown", "-teardown");
                    }

                    private void includeSuiteTeardownPage() {
                        pageData += newPageContent.toString();
                    }

//----------------------------------------------------------------------------------------

            private void updatePageContent() {
                pageData = newPageContent.toString();
            }

//----------------------------------------------------------------------------------------

                            //반복하지마라, 중복의 제거
                            private void include(String pageName, String arg) {
                                String inheritedPage = pageName.substring(0, 1);
                                if(inheritedPage != null) {
                                    String pagePathName = inheritedPage.toLowerCase();
                                    newPageContent.append(pagePathName).append(arg);
                                }
                            }
}
