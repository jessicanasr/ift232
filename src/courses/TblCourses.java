/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package courses;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "tbl_courses", catalog = "courses", schema = "")
@NamedQueries({
    @NamedQuery(name = "TblCourses.findAll", query = "SELECT t FROM TblCourses t"),
    @NamedQuery(name = "TblCourses.findByCourseId", query = "SELECT t FROM TblCourses t WHERE t.courseId = :courseId"),
    @NamedQuery(name = "TblCourses.findByCourseCode", query = "SELECT t FROM TblCourses t WHERE t.courseCode = :courseCode"),
    @NamedQuery(name = "TblCourses.findByCourseName", query = "SELECT t FROM TblCourses t WHERE t.courseName = :courseName"),
    @NamedQuery(name = "TblCourses.findByCourseDescription", query = "SELECT t FROM TblCourses t WHERE t.courseDescription = :courseDescription"),
    @NamedQuery(name = "TblCourses.findByCourseType", query = "SELECT t FROM TblCourses t WHERE t.courseType = :courseType"),
    @NamedQuery(name = "TblCourses.findByCourseNbOfCredits", query = "SELECT t FROM TblCourses t WHERE t.courseNbOfCredits = :courseNbOfCredits"),
    @NamedQuery(name = "TblCourses.findByCourseLab", query = "SELECT t FROM TblCourses t WHERE t.courseLab = :courseLab")})
public class TblCourses implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id")
    private Integer courseId;
    @Basic(optional = false)
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_description")
    private String courseDescription;
    @Column(name = "course_type")
    private String courseType;
    @Column(name = "course_nb_of_credits")
    private Integer courseNbOfCredits;
    @Column(name = "course_lab")
    private String courseLab;

    public TblCourses() {
    }

    public TblCourses(Integer courseId) {
        this.courseId = courseId;
    }

    public TblCourses(Integer courseId, String courseCode) {
        this.courseId = courseId;
        this.courseCode = courseCode;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        Integer oldCourseId = this.courseId;
        this.courseId = courseId;
        changeSupport.firePropertyChange("courseId", oldCourseId, courseId);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        String oldCourseCode = this.courseCode;
        this.courseCode = courseCode;
        changeSupport.firePropertyChange("courseCode", oldCourseCode, courseCode);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        String oldCourseName = this.courseName;
        this.courseName = courseName;
        changeSupport.firePropertyChange("courseName", oldCourseName, courseName);
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        String oldCourseDescription = this.courseDescription;
        this.courseDescription = courseDescription;
        changeSupport.firePropertyChange("courseDescription", oldCourseDescription, courseDescription);
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        String oldCourseType = this.courseType;
        this.courseType = courseType;
        changeSupport.firePropertyChange("courseType", oldCourseType, courseType);
    }

    public Integer getCourseNbOfCredits() {
        return courseNbOfCredits;
    }

    public void setCourseNbOfCredits(Integer courseNbOfCredits) {
        Integer oldCourseNbOfCredits = this.courseNbOfCredits;
        this.courseNbOfCredits = courseNbOfCredits;
        changeSupport.firePropertyChange("courseNbOfCredits", oldCourseNbOfCredits, courseNbOfCredits);
    }

    public String getCourseLab() {
        return courseLab;
    }

    public void setCourseLab(String courseLab) {
        String oldCourseLab = this.courseLab;
        this.courseLab = courseLab;
        changeSupport.firePropertyChange("courseLab", oldCourseLab, courseLab);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCourses)) {
            return false;
        }
        TblCourses other = (TblCourses) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "courses.TblCourses[ courseId=" + courseId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
