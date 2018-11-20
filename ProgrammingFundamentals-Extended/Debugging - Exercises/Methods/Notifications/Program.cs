using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Notifications
{
    class Program
    {
        static void Main(string[] args)
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                string command = Console.ReadLine();

                switch (command)
                {
                    case "success":

                        string operation = Console.ReadLine();
                        string message = Console.ReadLine();

                        ShowSuccess(operation, message);
                        break;

                    case "error":

                        string execution = Console.ReadLine();
                        int code = int.Parse(Console.ReadLine());

                        ShowError(execution, code);

                        break;
                }

            }
        }

        static void ShowError(string execution, int code)
        {
            Console.WriteLine($"Error: Failed to execute {execution}.");
            Console.WriteLine("==============================");
            Console.WriteLine($"Error Code: {code}.");

            if(code > 0)
            {
                Console.WriteLine("Reason: Invalid Client Data.");
            }
            else
            {
                Console.WriteLine("Reason: Internal System Failure.");
            }
        }

        static void ShowSuccess(string operation, string message)
        {
            
             Console.WriteLine($"Successfully executed {operation}.");
             Console.WriteLine("==============================");
             Console.WriteLine($"Message: {message}.");
        }
    }
}
