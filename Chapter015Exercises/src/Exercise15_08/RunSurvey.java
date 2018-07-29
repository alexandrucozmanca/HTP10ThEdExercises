package Exercise15_08;

public class RunSurvey 
{
	public static void main(String[] args) 
	{
		SaveRawData surveyData = new SaveRawData("src/Exercise15_08/RawData.txt");
		surveyData.openFile();
		surveyData.saveRawData();
		surveyData.closeFile();
		
		SaveSurvey survey = new SaveSurvey("src/Exercise15_08/RawData.txt", "src/Exercise15_08/Survey.txt");
		survey.openFiles();
		survey.saveSurvey();
		survey.closeFiles();

	}

}
