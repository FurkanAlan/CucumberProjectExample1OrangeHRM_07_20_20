package practice;

import com.hrm.utils.Constants;
import com.hrm.utils.ExcelUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelTest {
    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ With List Of Maps (With Header)" +
                " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Map<String, String>> dataSet = ExcelUtility.excelIntoListOfMaps(Constants.TEST_DATA_FILEPATH, "addEmp");
        for (Map<String, String> data : dataSet) {
            String fileName = data.get("firstName");
            String middleName = data.get("middleName");
            String lastName = data.get("lastName");
            String userName = data.get("userName");
            String password = data.get("password");

            System.out.println(fileName + " " + middleName + " " + lastName + " " + userName + " " + password + " ");
            System.out.println();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ With List Of List (No Header)" +
                " ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<ArrayList<String>> dataList = ExcelUtility.excelIntoListOfList(Constants.TEST_DATA_FILEPATH, "addEmp1");
        for (ArrayList<String> daStringArrayList : dataList) {
            String fileName = daStringArrayList.get(0);
            String middleName = daStringArrayList.get(1);
            String lastName = daStringArrayList.get(2);
            String userName = daStringArrayList.get(3);
            String password = daStringArrayList.get(4);

            System.out.println(fileName + " " + middleName + " " + lastName + " " + userName + " " + password + " ");
            System.out.println();
        }
    }
}
