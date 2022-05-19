using System;
using System.Collections.Generic;


namespace Utility
{
    class Program
    {
        

        static void Main(string[] args)
        {

            ODBCConnection oDBC = new ODBCConnection();
            
            
            List<Unemployed> list = oDBC.readResultSet();
            
            
            oDBC.WriteInfoJson(list, "Data.json");

            
        }
    }
}
