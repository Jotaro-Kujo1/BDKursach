using System;
using System.Collections.Generic;
using System.Text;

namespace Utility
{
    
    public class Unemployed
    {
        public int Id { get; set; }
        public string Surname { get; set; }
        public string Name { get; set; }
        public string Patronymic { get; set; }
        public int Age { get; set; }
        public int Gender { get; set; }
        public int Education { get; set; }
        public int Experience { get; set; }
        public string Contacts { get; set; }
        public int Country { get; set; }
        public int PreviousEmployment { get; set; }
        public string Passport { get; set; }

        public Unemployed(int id, string surname, string name, string patronymic, int age, int gender, int education, int experience, string contacts, int country, int previousEmployment, string passport)
        {
            Id = id;
            Surname = surname;
            Name = name;
            Patronymic = patronymic;
            Age = age;
            Gender = gender;
            Education = education;
            Experience = experience;
            Contacts = contacts;
            Country = country;
            PreviousEmployment = previousEmployment;
            Passport = passport;
        }

        public override string ToString()
        {
            return " ID: " + Id + " Surname" + Surname + " Name" + Name + " Patronymic" + Patronymic + " age" + Age + " Gender" + Gender
                + " education" + Education + " experience" + Experience + " contacts" + Contacts + " country" + Country + " previousEmployment"
                + PreviousEmployment + " passport" + Passport;
        }

    }
}
