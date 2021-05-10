package biddingApi.biddingApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import biddingApi.biddingApi.Entities.BiddingData;
import biddingApi.biddingApi.Model.BidPostRequest;
import biddingApi.biddingApi.Model.BidPostResponse;
import biddingApi.biddingApi.Model.BidPutRequest;
import biddingApi.biddingApi.Model.BidPutResponse;
import biddingApi.biddingApi.Service.BiddingService;

@RestController
public class BiddingController {

	@Autowired
	private BiddingService biddingService;
	
	@GetMapping("/bid")
	public List<BiddingData> getBid(@RequestParam(value="pageNo",required=false) Integer pageNo,@RequestParam(value="loadId",required=false) String loadId)
	{
		return biddingService.getBid(pageNo,loadId);
	}
	
	@GetMapping("/bid/{Id}")
	public BiddingData getBidById(@PathVariable String Id)
	{
		return biddingService.getBidById(Id);
	}
	
	
	@PostMapping("/bid")
	public BidPostResponse addBid(@RequestBody BidPostRequest bidPostRequest)
	{
		return biddingService.addBid(bidPostRequest);
	}
	
	@PutMapping("/bid/{id}")
	public BidPutResponse updateBid(@PathVariable String id,@RequestBody BidPutRequest bidPutRequest)
	{
		return biddingService.updateBid(id,bidPutRequest);
	}
	
	@DeleteMapping("/bid/{Id}")
	public void deleteBid(@PathVariable String Id)
	{
	biddingService.deleteBid(Id);
	}
	
	
}
