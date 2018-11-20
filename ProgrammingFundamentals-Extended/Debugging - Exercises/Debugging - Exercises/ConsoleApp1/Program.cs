using System;
class TrickyStrings
{
    static void Main(string[] args)
    {
        var delimiter = Console.ReadLine();

        var numberOfStrings = int.Parse(Console.ReadLine());

        var result = string.Empty;

        var currentString = string.Empty;

        for (int i = 0; i < numberOfStrings; i++)
        {
            if (i < numberOfStrings - 1)
            {
                currentString = Console.ReadLine();
                result += currentString + delimiter;
            }
            else
            {
                currentString = Console.ReadLine();
                result += currentString;
            }


        }
        Console.WriteLine(result);
    }
}