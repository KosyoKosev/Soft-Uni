using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _02.Ladybugs
{
    class Ladybugs
    {
        static void Main(string[] args)
        {
            var size = int.Parse(Console.ReadLine());

            var fail = new int[size];

            var initialIndexes = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();

            for (int i = 0; i < fail.Length; i++)
            {
                if (initialIndexes.Contains(i))
                {
                    fail[i] = 1;
                }
            }

            var comand = Console.ReadLine();

            while (comand != "end")
            {
                var split = comand.Split(' ').ToArray();
                var ladyBugIndex = int.Parse(split[0]);
                var direction = split[1];
                var flyLendht = int.Parse(split[2]);

                switch (direction)
                {
                    case "right":
                        if (ladyBugIndex >= fail.Length && ladyBugIndex < 0)
                        {

                        }
                        else
                        {
                            var curentIndex = ladyBugIndex;
                            var nextIndex = curentIndex + flyLendht;
                            if (fail[ladyBugIndex] == 0)
                            {

                            }
                            else
                            {
                                fail[curentIndex] = 0;
                                if (nextIndex >= fail.Length)
                                {

                                }
                                else
                                {
                                    for (int i = nextIndex; i < fail.Length; i++)
                                    {
                                        if (fail[i] == 1)
                                        {

                                        }
                                        else
                                        {
                                            fail[i] = 1;
                                            break;
                                        }
                                    }
                                }
                            }

                        }
                        break;
                    case "left":
                        if (ladyBugIndex >= fail.Length && ladyBugIndex < 0)
                        {

                        }
                        else
                        {
                            var curentIndex = ladyBugIndex;
                            var nextIndex = curentIndex - flyLendht;
                            if (fail[ladyBugIndex] == 0)
                            {

                            }
                            else
                            {
                                fail[curentIndex] = 0;
                                if (nextIndex < 0)
                                {

                                }
                                else
                                {
                                    for (int i = nextIndex; i >= 0; i--)
                                    {
                                        if (fail[i] == 1)
                                        {

                                        }
                                        else
                                        {
                                            fail[i] = 1;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                }

                comand = Console.ReadLine();
            }

            Console.WriteLine(string.Join(" ",fail));
        }
    }
}
