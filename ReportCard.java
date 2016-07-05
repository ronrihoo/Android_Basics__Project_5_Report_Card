import java.util.Arrays;

public class ReportCard {

    // Constants
    private static final int MAX_COURSE_QUANTITY = 10;
    private static final int A_MIN = 90;
    private static final int B_MIN = 80;
    private static final int C_MIN = 70;
    private static final int D_MIN = 60;
    private static final int W_CODE = -1;
    private static final int GRADE_NA_CODE = -1;
    private static final String GRADE_NA_STRING = "NA";
    private static final String COURSE_NA = "NA";
    private static final int COURSE_INDEX_NA_CODE = 0;
    private static final int GPA_SCALE = 25;
    private static final String LETTER_GRADE_A = "A";
    private static final String LETTER_GRADE_B = "B";
    private static final String LETTER_GRADE_C = "C";
    private static final String LETTER_GRADE_D = "D";
    private static final String LETTER_GRADE_F = "F";
    private static final String LETTER_GRADE_W = "W";
    private static final String LETTER_GRADE_NA = "NA";
    private static final String LETTER_GRADE_INVALID_ENTRY = "INVALID ENTRY";
    private static final String[] LETTER_GRADES = {LETTER_GRADE_A, LETTER_GRADE_B,
            LETTER_GRADE_C, LETTER_GRADE_D, LETTER_GRADE_F, LETTER_GRADE_W, LETTER_GRADE_NA};

    // Variables
    private int[] courseIndex = new int[MAX_COURSE_QUANTITY];
    private String[] courses = new String[MAX_COURSE_QUANTITY];
    private float[] grades = new float[MAX_COURSE_QUANTITY];
    private String[] letterGrades = new String[MAX_COURSE_QUANTITY];
    private int year;
    private float GPA;


    /**
     * Constructor.
     *
     * @param courses An array of course names.
     * @param grades  An array of grades.
     * @param year    The year relative to the report card.
     */
    public ReportCard(String[] courses, float[] grades, int year) {
        // Course names
        for (int i = 0; i < MAX_COURSE_QUANTITY; i++) {
            if (i < courses.length) {
                this.courses[i] = courses[i];
            } else {
                this.courses[i] = COURSE_NA;
            }
        }

        // Grades
        for (int i = 0; i < MAX_COURSE_QUANTITY; i++) {
            if (i < grades.length) {
                this.grades[i] = grades[i];
            } else {
                this.grades[i] = GRADE_NA_CODE;
            }
        }

        // Year
        this.year = year;

        // Course index list (as in a list of consecutive numbers: 1-through-10)
        for (int i = 0; i < MAX_COURSE_QUANTITY; i++) {
            if (i < MAX_COURSE_QUANTITY) {
                this.courseIndex[i] = i + 1;
            }
        }

        // Lettergrades
        for (int i = 0; i < MAX_COURSE_QUANTITY; i++) {
            if (i < grades.length) {
                if (grades[i] >= A_MIN) {
                    this.letterGrades[i] = LETTER_GRADE_A;
                } else if (grades[i] >= B_MIN) {
                    this.letterGrades[i] = LETTER_GRADE_B;
                } else if (grades[i] >= C_MIN) {
                    this.letterGrades[i] = LETTER_GRADE_C;
                } else if (grades[i] >= D_MIN) {
                    this.letterGrades[i] = LETTER_GRADE_D;
                } else if (grades[i] < D_MIN && grades[i] > W_CODE) {
                    this.letterGrades[i] = LETTER_GRADE_F;
                } else if (grades[i] == W_CODE) {
                    this.letterGrades[i] = LETTER_GRADE_W;
                } else {
                    this.letterGrades[i] = LETTER_GRADE_NA;
                }
            } else {
                this.letterGrades[i] = LETTER_GRADE_NA;
            }
        }

        // GPA
        this.GPA = 0;
        if (grades.length > 0) {
            for (int i = 0; i < grades.length; i++) {
                this.GPA += grades[i];
            }
            this.GPA = (this.GPA / grades.length) / GPA_SCALE;
        }
    }

    /**
     * Gets the index number of a specific course.
     *
     * @param courseIndexNum Starts at 1; not zero.
     * @return
     */
    public int getCourseIndex(int courseIndexNum) {
        if (courseIndexNum <= MAX_COURSE_QUANTITY && courseIndexNum >= 1) {
            return courseIndex[courseIndexNum - 1];
        } else {
            return COURSE_INDEX_NA_CODE;
        }
    }

    public String[] getCourses() {
        return courses;
    }

    /**
     * Gets the name of a specific course.
     *
     * @param courseIndexNum Starts at 1; not zero.
     * @return
     */
    public String getCourse(int courseIndexNum) {
        if (courseIndexNum <= MAX_COURSE_QUANTITY && courseIndexNum >= 1) {
            return courses[courseIndexNum - 1];
        } else {
            return COURSE_NA;
        }
    }

    public float[] getGrades() {
        return grades;
    }

    /**
     * Gets the grade of a specific course.
     *
     * @param courseIndexNum Starts at 1; not zero.
     * @return
     */
    public float getGrade(int courseIndexNum) {
        if (courseIndexNum <= MAX_COURSE_QUANTITY && courseIndexNum >= 1) {
            return grades[courseIndexNum - 1];
        } else {
            return GRADE_NA_CODE;
        }
    }

    /**
     * Provides string-based information for when a grade (float-type) does not exist.
     * Such as "NA", instead of "-1". This improves the UX.
     *
     * @return
     */
    public String getGradeNA_Str() {
        return GRADE_NA_STRING;
    }

    public String[] getLetterGrades() {
        return letterGrades;
    }

    /**
     * Gets the lettergrade for a specific course.
     *
     * @param courseIndexNum Starts at 1; not zero.
     * @return
     */
    public String getLetterGrade(int courseIndexNum) {
        if (courseIndexNum <= MAX_COURSE_QUANTITY && courseIndexNum >= 1) {
            return letterGrades[courseIndexNum - 1];
        } else {
            return LETTER_GRADE_NA;
        }
    }

    public int getYear() {
        return this.year;
    }

    public float getGPA() {
        return this.GPA;
    }

    public static int getMaxCourseQuantity() {
        return MAX_COURSE_QUANTITY;
    }

    /**
     * Sets a course name.
     *
     * @param course         Name of a specific course.
     * @param courseIndexNum Starts at 1; not zero.
     */
    public void setCourse(String course, int courseIndexNum) {
        if (courseIndexNum > 0 && courseIndexNum < MAX_COURSE_QUANTITY) {
            this.courses[courseIndexNum - 1] = course;
        }
    }

    /**
     * Sets the grade for a specific course.
     *
     * @param grade          A numerical grade for a specific course.
     * @param courseIndexNum Starts at 1; not zero.
     */
    public void setGrade(float grade, int courseIndexNum) {
        this.grades[courseIndexNum - 1] = grade;
        recalculateGPA();
    }

    /**
     * For those professors/teachers who decide the lettergrade their own way. Forces lettergrade
     * convention.
     *
     * @param letterGrade    A lettergrade for a specific course.
     * @param courseIndexNum Starts at 1; not zero.
     */
    public void setLetterGrade(String letterGrade, int courseIndexNum) {
        boolean letterFound = false;
        for (String letter : LETTER_GRADES) {
            if (letter == letterGrade) {
                this.letterGrades[courseIndexNum - 1] = letterGrade;
                letterFound = true;
            }
        }
        if (!letterFound) {
            this.letterGrades[courseIndexNum - 1] = LETTER_GRADE_INVALID_ENTRY;
        }
    }

    /**
     * Sets the year of the report card.
     *
     * @param year The year relevant to the grades on the report card.
     */
    public void setYear(int year) {
        this.year = year;
    }

    public void recalculateGPA() {
        int gradeable = 0;

        for (float a : this.grades) {
            if (a > -1) {
                gradeable += 1;
            }
        }

        float[] forGPA = new float[gradeable];

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > -1) {
                forGPA[i] = grades[i];
            }
        }

        if (forGPA.length > 0) {
            for (int i = 0; i < forGPA.length; i++) {
                this.GPA += forGPA[i];
            }
            this.GPA = (this.GPA / gradeable) / GPA_SCALE;
        }
    }

    @Override
    public String toString() {
        return "ReportCard{" +
                "courseIndex=" + Arrays.toString(courseIndex) +
                ", courses=" + Arrays.toString(courses) +
                ", grades=" + Arrays.toString(grades) +
                ", letterGrades=" + Arrays.toString(letterGrades) +
                ", year=" + year +
                ", GPA=" + GPA +
                '}';
    }
}
