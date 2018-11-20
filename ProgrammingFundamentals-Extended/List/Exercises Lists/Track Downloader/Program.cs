using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Track_Downloader
{
    class Program
    {
        static void Main(string[] args)
        {
            var blackList = Console.ReadLine().Split(' ').ToList();

            var playList = new List<string>();

            var command = Console.ReadLine();

            

            while (command != "end")
            {
                bool isContainsBlackList = false;

                for (int i = 0; i < blackList.Count; i++)
                {
                    if (command.Contains(blackList[i]))
                    {
                        isContainsBlackList = true;
                        break;
                    }
                }
                if (isContainsBlackList == false)
                {
                    playList.Add(command);
                }

                command = Console.ReadLine();
            }

            playList.Sort();

            foreach (var song in playList)
            {
                Console.WriteLine(song);
            }
        }
    }
}
