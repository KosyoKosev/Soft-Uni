using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _4.Re_Directory
{
    class ReDirectory
    {
        static void Main(string[] args)
        {
            string[] files = Directory.GetFiles("input");

            var fileInfo = new FileInfo("files");

            var extensionFiles = new HashSet<string>();

            foreach (var file in files)
            {
                extensionFiles.Add(fileInfo.Extension);
            }

            foreach (var extensionFile in extensionFiles)
            {
                Console.WriteLine(extensionFile);
            }
            
        }
    }
}
