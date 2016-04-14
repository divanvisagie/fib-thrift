using System;
using Thrift;
using Thrift.Protocol;
using Thrift.Server;
using Thrift.Transport;

namespace csharp_client
{
	class MainClass
	{
		public static void Main (string[] args)
		{
			Console.WriteLine ("starting");
			try
			{
				TTransport transport = new TSocket("localhost", 9090);
				TProtocol protocol = new TBinaryProtocol(transport);
				var a = 	new TMultiplexedProtocol(protocol,"");
				//Calculator.Client client = new Calculator.Client(protocol);
				MathService.Client client = new MathService.Client(protocol);

				transport.Open();
				try
				{
					int ans = client.fibonacci(30);
					Console.WriteLine("ping()");

				}
				catch 
				{
					Console.WriteLine("Invalid operation: ");
				}
				finally
				{
					transport.Close();
				}
			}
			catch (TApplicationException x)
			{
				Console.WriteLine(x.StackTrace);
			}

		}
	}
}
