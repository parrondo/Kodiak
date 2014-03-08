package com.clearpool.kodiak.feedlibrary.core.psx;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.clearpool.kodiak.feedlibrary.callbacks.IMdBookQuoteListner;
import com.clearpool.kodiak.feedlibrary.callbacks.IMdImbalanceListener;
import com.clearpool.kodiak.feedlibrary.core.MdFeed;
import com.clearpool.kodiak.feedlibrary.core.MdLibrary;
import com.clearpool.kodiak.feedlibrary.core.MdLibraryContext;
import com.clearpool.messageobjects.marketdata.BookQuote;
import com.clearpool.messageobjects.marketdata.Imbalance;
import com.clearpool.messageobjects.marketdata.MdServiceType;

public class PsxTest implements IMdBookQuoteListner, IMdImbalanceListener
{
	private static final Logger LOGGER = Logger.getLogger(PsxTest.class.getName());

	public PsxTest() throws IOException
	{
		MdLibraryContext context = new MdLibraryContext(1, false, 0, true, false);
		MdLibrary nasdaqLibrary = new MdLibrary(context, MdFeed.PSX, new String[] { "1" }, "127.0.0.1", "127.0.0.1", 5000, "C:\\nasdaq");
		nasdaqLibrary.registerService(MdServiceType.BOOK_XPSX, this);
		nasdaqLibrary.registerService(MdServiceType.IMBALANCE_XPSX, this);
		nasdaqLibrary.initProcessors();
		context.start();
	}

	@Override
	public void bookQuoteReceived(BookQuote bookQuote)
	{
		System.out.println(bookQuote);
	}

	@Override
	public void imbalanceReceived(Imbalance imbalance)
	{
		System.out.println(imbalance);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		try
		{
			PsxTest server = new PsxTest();
		}
		catch (Exception e)
		{
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}