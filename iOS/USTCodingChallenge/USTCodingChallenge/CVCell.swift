//
//  CVCell.swift
//  USTCodingChallenge
//
//  Created by Varun Batta on 2019-Nov-03.
//  Copyright © 2019 Varun Batta. All rights reserved.
//

import UIKit

class CVCell: UITableViewCell {

    @IBOutlet weak var cvLabel: UILabel!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    func setLabel(cvInformation: String) {
        cvLabel.text = cvInformation
    }
}
